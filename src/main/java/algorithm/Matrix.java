package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mjrt on 4/9/2017.
 */
public class Matrix {
    long mat[][];
    long MOD;
    public int row,col;

    public Matrix(int row, int col, long MOD) {
        this.row = row;
        this.col = col;
        this.MOD = MOD;
        mat = new long[row][col];
    }

    public Matrix multiply(Matrix r){

        if(col != r.row)    return null;

        Matrix res = new Matrix(row,r.col,MOD);
        for(int i = 0 ; i < row ; i++)
            Arrays.fill(res.mat[i],0);

        for(int i = 0 ; i < row ; i++)
            for(int j = 0 ; j < r.col; j++)
                for(int k = 0 ; k < col ; k++)
                    res.mat[i][j] = (res.mat[i][j]+mat[i][k]*r.mat[k][j]) % MOD;
        return res;
    }

    public Matrix power(long n){

        Matrix res = new Matrix(row,col,MOD);
        Matrix x= this;
        for(int i = 0 ; i < row ; i++){
            Arrays.fill(res.mat[i],0);
            res.mat[i][i] = 1;
        }

        for(;n !=0; n>>=1){
            if((n&1)==1)
                res = res.multiply(x);
            x = x.multiply(x);
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Matrix("+row+","+col+","+MOD+"):\n");
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                builder.append(mat[i][j]+"\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}