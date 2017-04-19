package Interview;

/**
 * Created by mjrt on 4/18/2017.
 */
public class Base {
    int atoi(char[] string){
        int index = 0;
        boolean sign = true;
        if(string[index] == '-'){
            sign = false;
            index++;
        } else if(string[index] == '+'){
            index++;
        }
        while(string[index] == '0')
            index++;

        int result = 0;
        for(int i = index ; i < string.length ; i++){
            result = result*10+(int)(string[i]-'0');
        }
        return sign?result:-result;
    }

    char[] itoa(int x){
        int length = getIntLength(x);
        boolean sign = (x>=0);
        if(!sign){
            length++;
            x=-x;
        }

        char[] string = new char[length];
        for(int i = length-1 ; i >=1 ; i-- ){
            string[i] = (char)(x%10+'0');
            x/=10;
        }

        string[0] = sign?((char)(x+'0')):'-';
        return string;
    }

    int getIntLength(int x){
        return x==0?1:(int)Math.ceil(Math.log10(Math.abs(x)+1));
    }
}
