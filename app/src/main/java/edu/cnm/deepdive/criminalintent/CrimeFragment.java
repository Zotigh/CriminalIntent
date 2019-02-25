package edu.cnm.deepdive.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class CrimeFragment extends Fragment {

  private Crime Crime;
  private EditText TitleField;
  private Button DateButton;
  private CheckBox SolvedCheckBox;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Crime = new Crime();
  }

  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    View v =
        inflater.inflate(R.layout.fragment_crime, container,
            false);

    TitleField = (EditText) v.findViewById(R.id.crime_title);
    TitleField.addTextChangedListener(new TextWatcher()
    {
      @Override
      public void beforeTextChanged(
        CharSequence s, int start, int count,
      int after) {
// This space intentionally left blank
    }
      @Override
      public void onTextChanged(
        CharSequence s, int start, int before, int count)
      {Crime.setTitle(s.toString());
    }
      @Override
      public void afterTextChanged(Editable s)
// This one too
{
      }
    });

    DateButton = (Button)v.findViewById(R.id.crime_date);
    DateButton.setText(Crime.getDate().toString());
    DateButton.setEnabled(false);

    SolvedCheckBox =(CheckBox)v.findViewById(R.id.crime_solved);
    SolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void
      onCheckedChanged(CompoundButton buttonView,
          boolean isChecked){
        Crime.setSolved(isChecked);
      }
    });

    return v;
  }
}
