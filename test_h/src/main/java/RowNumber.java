import org.apache.hadoop.hive.ql.exec.UDF;


//首先我们的UDF函数输入是多个列的值，传入多个值表示用多个值是否相同来打序号，对于我们的场景只要1个（就是id），函数row_number(),必须带一个或者多个列参数，
// 如ROW_NUMBER(col1, ....)，它的作用是按指定的列进行分组生成行序列。在ROW_NUMBER(a,b) 时，若两条记录的a，b列相同，则行序列+1，否则重新计数。
//这个函数最关键的部分就是得先有序，所以加序号前必须保证数据有序


public class RowNumber extends UDF{

    private static int MAX_VALUE = 50;
    private static String comparedColumn[] = new String[MAX_VALUE];
    private static int rowNum = 1;

    public int evaluate(Object... args) {
        String columnValue[] = new String[args.length];
        for (int i = 0; i < args.length; i++){
            columnValue[i] = args[i].toString();
        }

        if (rowNum == 1) {
            for (int i = 0; i < columnValue.length; i++)
                comparedColumn[i] = columnValue[i];
        }

        for (int i = 0; i < columnValue.length; i++) {
            if (!comparedColumn[i].equals(columnValue[i])) {
                for (int j = 0; j < columnValue.length; j++) {
                    comparedColumn[j] = columnValue[j];
                }
                rowNum = 1;
                return rowNum++;
            }
        }
        return rowNum++;
    }
}


//使用方法
//create temporary function RowNumber as 'xxx.xxx.xxx.udf.RowNumber';
//select id, login_time from (select * from log distribute by id sort by id, login_time asc) tmp where RowNumber(id)=1;

