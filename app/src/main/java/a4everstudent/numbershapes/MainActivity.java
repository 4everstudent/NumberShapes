package a4everstudent.numbershapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//// TODO: 07-09-2016 Add try block to handle lack of number insertion  
public class MainActivity extends AppCompatActivity {

    class Number{
        int number;

        boolean isTriangular(){
            int x = 0;
            int triangularNumber = 0;
            while(triangularNumber<number){
                triangularNumber = x*(x+1)/2;
                x++;
            }

            if(triangularNumber == number){
                return true;
            }
            else{
                return false;
            }
        }

        boolean isSquare(){

            double squareRoot = Math.sqrt(number);
            if( squareRoot == Math.floor(squareRoot)){
                return true;
            }
            else{
                return false;
            }

        }

        public String isWhat(){
            if(isTriangular() && isSquare()){
               return " is both Triangular and Square.";
            }
            else{
                if(!isTriangular() && !isSquare()){
                    return " is neither Triangular or Square.";
                }
                else{
                    if(isTriangular()){
                        return " is Triangular but not Square.";
                    }
                    else{
                        return " is Square but not Triangular.";
                    }

                }

            }

        }




    }


    public void testNumber(View view){

        EditText usersNumber = (EditText) findViewById(R.id.userNumber);

        if(usersNumber.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter a number ", Toast.LENGTH_LONG).show();
        }
        else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(usersNumber.getText().toString());

            Toast.makeText(getApplicationContext(), myNumber.number + myNumber.isWhat(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
