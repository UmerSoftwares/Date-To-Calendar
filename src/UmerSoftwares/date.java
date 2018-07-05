package UmerSoftwares;

/**
 *
 * @author Hafiz Muhammad Umer
 */
public class date {
    public static int day(int d,int m,String y)
    {
        int ym4=mod4(y);
        int ym7=mod7(y);
        int ly=modly(y);
        final int[] mc={0,0,3,3,6,1,4,6,2,5,0,3,5};
        int n=(ym4==0)?1:0;
        int c=(m==1 || m==2)? 1:0;
        int dc=5+ym7+d+ly+mc[m]-n*c;
        dc%=7;
        return dc;
    }
    private static int modly(String s)
    {
        if (s.length()<=2)
        {
            int i=Integer.parseInt(s);
            i=(i-(i%4))/4;
            i=mod7(""+i);
            return i;
        }
        int i=Integer.parseInt(s.substring(s.length()-2));
        s=s.substring(0, s.length()-2);
        i-=mod4((""+i));
        int h=mod7(s);
        h*=25;
        i/=4;
        i+=h;
        i%=7;
        return i;
    }
    private static int mod4(String s)
    {
        if (s.length()<=2)
            return (Integer.parseInt(s))%4;
        else
            return (Integer.parseInt(s.substring(s.length()-2)))%4;
    }
    public static boolean isLeap(String s)
    {
        if (mod4(s)==0)
            return true;
        return false;
    }
    private static int mod7(String s)
    {
        int r=0;
        while (s.length()>6)
        {
            int i=Integer.parseInt(s.substring(s.length()-6));
            s=s.substring(0, s.length()-6);
            r+=i%7;
            r%=7;
        }
        int i=Integer.parseInt(s);
        r+=i;
        r%=7;
        return r;
    }    
}

