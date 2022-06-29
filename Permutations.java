import java.util.Scanner;
public class Permutations{
   public  static String sourceString="";
   public static int validPermutation=0;

    public static void is_permutation(String query_string){
        boolean flag=false;
        if(check(query_string)){

            int[] source=char_count(sourceString);
            int[] query=char_count(query_string);
            for(int i=0;i<26;i++){

                source[i]=source[i]-query[i];
                if(source[i]!=0){

                    break;
                }
            }
            for(int j=0;j<26;j++){

                if(source[j]==0){

                    flag=true;
                }else{

                    flag=false;
                    break;
                }
            }
            if(flag){
                ++validPermutation;
            }
        }

    }

    public static boolean check(String query_string){
        boolean flag=false;
        int sourceStringLength=sourceString.length();
        int queryStringLength=query_string.length();

        if(sourceStringLength==queryStringLength){

            flag=true;
        }
        return flag;
    }
    public static int[] char_count(String str){

        int[] characterArray = new int[26];
        char[] array = str.toCharArray();
        int length=str.length();

        for(int i=0;i<length;i++){

            int ascii=(int)array[i];
            characterArray[ascii] += 1;
        }
        return characterArray;
    }

    public static String solve(int Q){
        String query="";
        String result="";
        for(int i=0;i<Q;i++){

            while(sc.hasNext()){

                query=sc.next();
            }
            is_permutation(query);
        }

        result="Found"+ validPermutation+ "permutations in"+ Q+" queries";


    }
    public static void main(String[] args){
        int Q=0;
        Scanner var = new Scanner(System.in);   
        while(var.hasNext()){
            sourceString=var.next();
            Q=var.nextInt();
        }
        System.out.print(solve(Q));

    }
}