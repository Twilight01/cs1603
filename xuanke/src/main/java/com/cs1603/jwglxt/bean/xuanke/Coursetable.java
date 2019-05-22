package com.cs1603.jwglxt.bean.xuanke;

public class Coursetable {
    private Integer semester;
    private String sid;
    private String year;
    private Integer[][] table;
    private String[][] ttname;
    private String[][] tcname;
    private String[][] classroom;
    //static public details[][] detailtable;


    public Coursetable(){//构造函数
        //实例化两个数组
        table = new Integer[8][15];
        ttname = new String[8][15];
        tcname = new String[8][15];
        classroom = new String[8][15];

        for(int i=0;i<8;i++)
                    for(int j=0;j<15;j++) {
                        this.ttname[i][j]="";
                        this.tcname[i][j]="";
                        this.classroom[i][j]="";
                   }
    }

    public Integer getSemester() {
        return semester;
    }

    public Integer[][] getTable() {
        return table;
    }

    public String getSid() {
        return sid;
    }

    public String[][] getClassroom() {
        return classroom;
    }

    public String getYear() {
        return year;
    }

    public String[][] getTcname() {
        return tcname;
    }

    public String[][] getTtname() {
        return ttname;
    }

    public void setTable(Integer i, Integer j, Integer value, String cname, String tname ,String classrooms) {//设置table的值
        this.table[i][j]=value;
        //this.ttname[i][j]=tname;
        for(int k=0;k<tname.length();k++)
            ttname[i][j]+=tname.charAt(k);
        for(int k=0;k<cname.length();k++)
            tcname[i][j]+=cname.charAt(k);
        for(int k=0;k<classrooms.length();k++)
            classroom[i][j]+=classrooms.charAt(k);
        //this.tcname[i][j]=cname;
        /*detailtable[i][j].week=i;
        detailtable[i][j].num=j;
        detailtable[i][j].cname=cname;
        detailtable[i][j].tname=tname;
        detailtable[i][j].num=j;
        detailtable[i][j].week=i;
        */
        //this.table = table;
        //没写应用
    }

    public Integer gettablenum(int i,int j){
        return table[i][j];
    }

    static public Integer CtNumber(String s)//汉字转int
    {
        if(s.equals("一"))
            return 1;
        else if(s.equals("三"))
            return 3;
        else if(s.equals("四"))
            return 4;
        else if(s.equals("五"))
            return 5;
        else if(s.equals("六"))
            return 6;
        else if(s.equals("七"))
            return 7;
        else if(s.equals("二"))
            return 2;
        else;
        return 0;
    }
    public static String tString(Integer a)//int 转 string
    {
        String s = "";
        if(a==0)
            return "0";
        while(a!=0){
            s+=(char)('0'+a%10);
            a=a/10;
        }
        String st = "";
        for(int i=0;i<s.length();i++)
            st+=s.charAt(s.length()-i-1);
        return st;
    }
    public static  Integer tNumber(String s)//stirng 转 int
    {
        int res=0;
        for(int i=0;i<s.length();i++){
            res = res*10;
            res+=s.charAt(i)-'0';
        }
        return res;
    }
}
