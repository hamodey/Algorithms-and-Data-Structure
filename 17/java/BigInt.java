import java.math.BigInteger;

public class BigInt {
    public int ndigits;
    // public for test purposes
    public char data[];
    public static int firstValue;
    public BigInt(int _ndigits) {
        this.ndigits = _ndigits;

        data = new char[_ndigits];
    }
    public BigInt(String s) {

        ndigits = s.length();
        char charArray[] = s.toCharArray();

        for(int i = 0; i < charArray.length / 2; i++){
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }
        for(int i = 0 ;i < ndigits; i++){
            data = charArray;
            int numericValue = Character.getNumericValue(charArray[i]);

            data[i] = (char)numericValue;
        }
        data = charArray;
    }

    public char get(int i) {
        if(i >= data.length) return 0;
        return data[i];
    }

    public BigInt Add(BigInt y) {

    	int n = 1, c = 0, myArr [];

    		//check the biggest number
    	if ( y.ndigits > this.ndigits) {
    		n = n + y.ndigits;
    	}else {
    		n = n + this.ndigits;
    	}

    	BigInt r = new BigInt(n);
    	myArr = new int [n];
    	for ( int i = 0; i < n; i++) {
    		myArr[i] = this.get(i) + y.get(i) + c;

        	if (myArr[i] > 9) {
        		c = 1;
        		myArr[i] = myArr[i] % 10;
    		}else {
        		c = 0;
        	}
        	r.data[i] = Character.valueOf((char)myArr[i]);
        }
    	return r;
    }

    public BigInt Sub(BigInt y) {
        BigInt s = new BigInt (data.length);
        if(y.data.length < data.length) {
        	BigInt a = new BigInt(data.length);
        	for(int i = 0; i < y.data.length; i++) {
        		a.data[i] = y.data[i];
        	}
        	y.data = a.data;
        }
    	int b = 0;
    	for (int i = 0; i < data.length; i++) {
    		int value = data[i] - y.data[i] - b;
    		if(value < 0) {
    			value= value + 10;
    			b = 1;
    		}
    		else
    			b = 0;
    		s.data[i] = (char) value;
    	}
        return s;
    }

    public BigInt Shift(int n) {
        BigInt shiftedOne = new BigInt(this.data.length + n);
        for(int i = 0; i < this.data.length; i++){
            shiftedOne.data[i+n] = data[i];
        }
        return shiftedOne;
    }

    public BigInt MulByDigit(char c) {
        BigInt multipler = new BigInt(data.length + 1);
        int over = 0;
        for(int i = 0; i < data.length; i++){
            int temp = data[i] * c + over;
            multipler.data[i] = (char)(temp % 10);
            over = temp/10;
        }
        multipler.data[multipler.data.length-1] = (char) over;
        return multipler;
    }

    public BigInt Mul(BigInt y) {
        BigInt a = new BigInt(1);

        String yData = new String(y.data);
        String reversedOne = new StringBuilder(yData).reverse().toString();
        int reversedLen = reversedOne.length();

        char [] temp = new char[reversedLen];
        for (int i = 0; i < reversedLen; i++) {
            temp[i] = (char)(reversedOne.charAt(i) + 48);
        }
        String b= new String(temp);
        BigInteger d = new BigInteger(b);

        while (d.compareTo(BigInteger.ZERO) > 0) {
        	a = a.Add(this);
        	d = d.subtract(BigInteger.ONE);
        }


        return a;
    }

    public BigInt Rem(BigInt d) {
    BigInt rem1 = this.Div(d);
    BigInt rem2 = new BigInt(firstValue + "");

    return rem2;
    }
    public BigInt getSelf(){
        return this;
    }
    public String toString(){
        String a = "";
        for(int i = 0; i < data.length; i ++){
            System.out.print(this.data[i]);
            a = a + data[i];
        }
        return a;
    }
    public boolean isMore(BigInt a){
        // int self = this.ndigits;
        // int compared = a.ndigits;
        int self = this.data.length;
        int compared = a.data.length;
        boolean selfBigger = false;
        if(self > compared){
            // System.out.println("Self is bigger");
            selfBigger = true;
            return true;
        }else if(self == compared){
            for(int i = 0; i < self; i++){
                if(this.data[i] > a.data[i]){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }


    public BigInt Div(BigInt d) {

        	BigInt dividend = new BigInt(ndigits);

        	for(int i= 0; i < data.length; i++) {
        		dividend.data[i] = data[i];
        	}
        	String a = new StringBuilder(new String(dividend.data)).reverse().toString();
        	String b = new StringBuilder(new String(d.data)).reverse().toString();
        	char [] temp1 = new char[a.length()];
            for (int i = 0; i < a.length(); i++) {
           	    temp1[i] = (char)(a.charAt(i) + 48);
            }
            a = new String (temp1);
            char [] temp2 = new char[b.length()];
            for (int i = 0; i < b.length(); i++) {
           	    temp2[i] = (char)(b.charAt(i) + 48);
            }
            b = new String (temp2);
        	firstValue = Integer.parseInt(a);
        	int secValue = Integer.parseInt(b);
        	long count  = 0;
        	while (firstValue >= secValue) {
        		dividend = dividend.Sub(d);
            	a = new StringBuilder(new String(dividend.data)).reverse().toString();
            	temp1 = new char[a.length()];
                for (int i = 0; i < a.length(); i++) {
                    temp1[i] = (char)(a.charAt(i) + 48);
                }
                a  = new String(temp1);
                firstValue = Integer.parseInt(a);
                count++;
        	}

        	String counterString = count + "";
        	BigInt end = new BigInt(counterString.length());
        	char q[] = new char[counterString.length()];
            for (int i = counterString.length()-1, j = 0; i>=0; i--, j++) {
            	q[j] = (char) (counterString.charAt(i) -'0' );
            }
        end.data = q;

       return end;
    }




}
