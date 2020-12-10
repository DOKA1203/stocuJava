public class Main {
    private static int[][] n = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    static boolean canplaceInSq(int y,int x ,int su)
    {
        y/=3;
        x/=3;

        y*=3;
        x*=3;

        for(int i=y;i<y+3;i++){
            for(int j=x;j<x+3;j++){
                if(n[i][j]==su)return false;
            }
        }
        return true;
    }
    static boolean canplace(int y,int x , int su)
    {
        for(int i=0;i<9;i++)if(n[y][i] == su)return false;

        for(int i=0;i<9;i++)if(n[i][x] == su)return false;

        return canplaceInSq(y, x, su);
    }
    static boolean Dfs(int y, int x)
    {
        if(x==9)
        {
            x=0;
            y++;
        }
        if(y==9)
        {
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    System.out.print(n[i][j] + " ");
                }System.out.println();
            }
            return true;
        }
        if(n[y][x] == 0)
        {
            for(int i=1;i<=9;i++)
            {
                if(canplace(y,x,i))
                {
                    n[y][x] = i;
                    if(Dfs(y,x+1)) return true;
                    n[y][x] = 0;
                }
            }
        }
        else{
            return Dfs(y,x+1);
        }
        return false;
    }

    public static void main(String[] args)
    {
        Dfs(0,0);
    }
}
