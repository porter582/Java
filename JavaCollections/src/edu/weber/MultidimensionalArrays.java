package edu.weber;

public class MultidimensionalArrays {
    public static void main(String[] args) {

        String[][] states = new String[50][2];
        states[0][0] = "California";
        states[0][1] = "Sacramento";

        states[1][0] = "Oregon";
        states[1][1] = "Salem";

        states[2][0] = "Washington";
        states[2][1] = "Olympia";

        for(int i = 0; i < states.length; i++)
        {
            StringBuilder builder = new StringBuilder();

            for(int j = 0; j < states[0].length; j++)
            {
                if(j == 0)
                {
                    builder.append("The capital of ");
                }
                else
                {
                    builder.append(" is ");
                }
                builder.append(states[i][j]);
            }
            System.out.println(builder);
        }
    }
}
