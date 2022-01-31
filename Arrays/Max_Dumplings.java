public class Max_Dumplings {
    public static void main(String[] args) {
        Solution_problem obj=new Solution_problem();
        int[] result=obj.encryptData(new int[]{10,9,12,3},4 ,new int[]{1,2}, new int[]{2,1}, new int[]{5,10},2);
        for(int i:result)
            System.out.print(i+" ");
    }
}

class Solution_problem{
    public int[] encryptData(int[] input1,int input2,int[] input3,int[] input4,int[] input5,int input6){
        for(int i=0;i<input6;i++){
            //starting
            if(input3[i]==1){
                for(int j=0;j<input4[i];j++){
                    input1[j]=input1[j]^input5[i];
                }
            }
            //ending
            else{
                for(int j=input2-1;j>=input2-input4[i];j--){
                    input1[j]=input1[j]^input5[i];
                }
            }
        }
        return input1;
    }
}