//https://www.youtube.com/watch?v=GTJr8OvyEVQ (video referred)
//https://www.youtube.com/watch?v=V5-7GzOfADQ

public class Solution {

        public static void main(String[] args) {
            /* Enter your code here. Print output to STDOUT. Your class should be named Solution. */
            String str = "ABXABCABCABY";
            String pattern = "ABCABY";
            int[] arr = new int[pattern.length()];
            arr[0] = 0;
            
            for(int j=0,i =1; i<pattern.length();){
                
                if(pattern.charAt(j) == pattern.charAt(i)){
                    arr[i] = j+1;
                    ++i;
                    ++j;
                }
                else{
                    
                    --j;
                    if(j <=0){
                        j=0;
                        arr[i] = 0;
                        ++i;
                    }else{
                            j = arr[j];
    
                    }
                }
                
            }
            for(Integer i : arr){
                System.out.println(i);
            }
            
            int k,m;
            for(k=0,m=0;m<str.length();){
                
                if(pattern.charAt(k) == str.charAt(m)){
                    
                    ++k;
                    ++m;
                }
                else{
                    --k;
                    if(k <= 0){
                        k=0;
                        
                        ++m;
                    }else{
                         k = arr[k];
    
                    }
                }
            }
            
            System.out.println(k);
        }
    }
    