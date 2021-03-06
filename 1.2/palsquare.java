/*
ID: yuzhou.1
LANG: JAVA
TASK: palsquare
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class palsquare
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader in = new BufferedReader( new FileReader( "palsquare.in" ) );
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( "palsquare.out" ) ) );
        
        // Read in the base
        int b = Integer.parseInt( in.readLine() );
        Converter c = new Converter();
        in.close();
        
        // Ignore this; it's unneeded (just use single variable inside for loop)
        boolean[] isPal = new boolean[ 301 ];
        for( int i = 1; i <= 300; i++ )
        {
            isPal[ i ] = true;
            
            // Converts the square to digits in base b (reversed)
            int square = i * i;
            ArrayList<Integer> digits = new ArrayList<Integer>();
            while( square > 0 )
            {
                digits.add( square % b );
                square = square / b;
            }
            
            // Checks that the digits form a palindrome
            for( int j = 0; j < digits.size(); j++ )
            {
                if( digits.get( j ) != digits.get( digits.size() - j - 1 ) )
                {
                    isPal[ i ] = false;
                }
            }
            
            if( isPal[ i ] )
            {
            	// Convert the not-squared number to base b digits (reversed)
                int temp = i;
                ArrayList<Integer> digits2 = new ArrayList<Integer>();
                while( temp > 0 )
                {
                    digits2.add( temp % b );
                    temp = temp / b;
                }
                
                // Print out the base b digits of the not-squared number (using the converter if necessary)
                for( int j = 0; j < digits2.size(); j++ )
                {
                    if(  digits2.get( digits2.size() - j - 1 ) < 10 )
                    {
                        out.print( digits2.get( digits2.size() - j - 1 ) );   
                    }
                    else
                    {
                        out.print( c.convert( digits2.get( digits2.size() - j - 1 ) ) );
                    }
                }
                out.print( " " );
                
                // Print out the base b digits of the squared number (using the converter if necessary)
                for( int j = 0; j < digits.size(); j++ )
                {
                    if(  digits.get( digits.size() - j - 1 ) < 10 )
                    {
                        out.print( digits.get( digits.size() - j - 1 ) );   
                    }
                    else
                    {
                        out.print( c.convert( digits.get( digits.size() - j - 1 ) ) );
                    }
                }
                out.println();
            }
        }
        out.close();
    }
}

class Converter
{
    public Converter()
    {
        
    }
    
    public char convert( int digit )
    {
        if( digit == 10 )
        {
            return 'A';
        }
        else if( digit == 11 )
        {
            return 'B';
        }
        else if( digit == 12 )
        {
            return 'C';
        }
        else if( digit == 13 )
        {
            return 'D';
        }
        else if( digit == 14 )
        {
            return 'E';
        }
        else if( digit == 15 )
        {
            return 'F';
        }
        else if( digit == 16 )
        {
            return 'G';
        }
        else if( digit == 17 )
        {
            return 'H';
        }
        else if( digit == 18 )
        {
            return 'I';
        }
        else if( digit == 19 )
        {
            return 'J';
        }
        else
        {
            return 'Z';
        }
    }
}