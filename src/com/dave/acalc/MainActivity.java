package com.dave.acalc;


import java.util.HashMap;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private StringBuilder currentString = new StringBuilder();
	private double numInput;
	private double numAnswer;
	private HashMap<String, Operation> operations = new HashMap<String, Operation>();
	private Operation op;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		operations.put("+", new Addition());
		operations.put("-", new Subtraction());
		operations.put("*", new Multiplication());
		operations.put("/", new Division());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.item_about:
//	            newGame();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void onNumButtonClick(View view) {
		Button button = (Button) view;
		String numberClicked = button.getText().toString();
		currentString.append(numberClicked);
		
		numInput = Double.parseDouble(currentString.toString());		
		updateInputText();
	}

	public void onOperatorButtonClick(View view) {
		Button button = (Button) view;
		String operator = button.getText().toString();
		op = operations.get(operator);
		
		numAnswer = numInput;
		clearInput();

		updateAnswerTextWithOperation();
		updateInputText();
	}

	public void onEqualButtonClick(View view){
		if(op != null) {
			numAnswer = op.calculate(numAnswer, numInput);
			clearInput();
		}
		else {
			// invalid operation
		}
		updateAnswerText();
		updateInputText();
		op = null;
	}

	private void clearInput() {
		numInput = 0;
		currentString.setLength(0);
	}
	
	private void updateInputText() {
		TextView textView = (TextView) findViewById(R.id.textInput);
		textView.setText(String.valueOf(numInput));
	}
	
	private void updateAnswerText() {
		TextView textView = (TextView) findViewById(R.id.textAnswer);
		textView.setText(String.valueOf(numAnswer));
	}

	private void updateAnswerTextWithOperation() {
		TextView textView = (TextView) findViewById(R.id.textAnswer);
		textView.setText(String.valueOf(numAnswer) + " " + op.getOperator());
	}
}

