package com.example.pie;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.content.Intent;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
 
public class Second extends Activity {
 
  private RelativeLayout mainLayout;
  private LinearLayout layout;
  private PieChart mChart;
  private PieChart mChart1;

  // we're going to display pie chart for smartphones martket shares
  int[] yData = new int[5];
  //int yData1[];
  private String[] xData = { "Sony", "Huawei", "LG", "Apple", "Samsung" };
 
  private String[] xData1 = { "1 January Monday", "2 January Tuesday", "3 January Wenesday","4 January Thursday","5 January Friday","6 January Monday", "7 January Monday","8 January Monday","9 January Monday","10 January Monday","11 January Monday","12 January Monday","13 January Monday","14 January Monday","15 January Monday","16January Monday","17 January Monday","18 January Monday","19 January Monday","20 January Monday","21 January Monday","22 January Monday","23 January Monday","24 January Monday","25 January Monday","26 January Monday","27 January Monday","28 January Monday","29 January Monday","30 January Monday" };
 
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
    layout = (LinearLayout) findViewById(R.id.layout);
    String ad1=getIntent().getExtras().getString("d1");
    String ad2=getIntent().getExtras().getString("d2");
    String ad3=getIntent().getExtras().getString("d3");
    String ad4=getIntent().getExtras().getString("d4");
    String ad5=getIntent().getExtras().getString("d5");
    
    int d6 = Integer.parseInt(ad1);
    int d7 = Integer.parseInt(ad2);
    int d8 = Integer.parseInt(ad3);
    int d9 = Integer.parseInt(ad4);
    int d10 = Integer.parseInt(ad5);
    
    yData[0]=d7;
    yData[1]=d8;
    yData[2]=d9;
    yData[3]=d10;
   
    
    final int[] yData1 = new int[d7];
    for(int i=0; i<d7; i++)
    {
    	yData1[i]=1;
    }
    mChart = new PieChart(this);
    mChart1 = new PieChart(this);
    // add pie chart to main layout
    mainLayout.addView(mChart);
    layout.addView(mChart1);
    mainLayout.setBackgroundColor(Color.parseColor("#55656C"));
    layout.setBackgroundColor(Color.parseColor("#55656C"));

    // configure pie chart
    mChart1.setMinimumWidth(100);
    mChart1.setMinimumHeight(200);
    mChart1.setUsePercentValues(true);
    mChart1.setDescription("");
    mChart1.setMarkerView(null);
 
    // enable hole and configure
    mChart1.setDrawHoleEnabled(true);
    mChart1.setHoleColorTransparent(true);
    mChart1.setHoleRadius(20);
    mChart1.setTransparentCircleRadius(30);
   
 
    // enable rotation of the chart by touch
    mChart1.setRotationAngle(0);
    mChart1.setRotationEnabled(true);
    
    mChart1.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
   	 
        @Override
        public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
          // display msg when value selected
          if (e == null)
            return;
   
          Toast.makeText(Second.this,
            xData1[e.getXIndex()] + " = " + e.getVal() + "%", Toast.LENGTH_SHORT).show();
        }
   
        @Override
        public void onNothingSelected() {
   
        }
      });
    // configure pie chart
    mChart.setMinimumWidth(400);
    mChart.setMinimumHeight(700);
    mChart.setUsePercentValues(true);
    mChart.setDescription("");
    mChart.setMarkerView(null);
 
    // enable hole and configure
    mChart.setDrawHoleEnabled(true);
    mChart.setHoleColorTransparent(true);
    mChart.setHoleRadius(60);
    mChart.setTransparentCircleRadius(65);
   
 
    // enable rotation of the chart by touch
    mChart.setRotationAngle(0);
    mChart.setRotationEnabled(true);
    
   
    mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
      	 
        @Override
        public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
          // display msg when value selected
          if (e == null)
            return;
   
          Toast.makeText(Second.this,
            xData1[e.getXIndex()] + " = " + e.getVal() + "%", Toast.LENGTH_SHORT).show();
        }
   
        @Override
        public void onNothingSelected() {
   
        }
      });
    
    // add data
    addData();
    addData1(yData1);
 
    // customize legends
    Legend l = mChart.getLegend();
    l.setPosition(LegendPosition.RIGHT_OF_CHART);
    l.setXEntrySpace(2);
    l.setYEntrySpace(1);
    
    Legend l1 = mChart1.getLegend();
    l1.setPosition(LegendPosition.RIGHT_OF_CHART);
    l1.setXEntrySpace(2);
    l1.setYEntrySpace(1);
  }
 
  private void addData() {
    ArrayList<Entry> yVals1 = new ArrayList<Entry>();
 
    for (int i = 0; i < yData.length; i++)
      yVals1.add(new Entry(yData[i], i));
 
    ArrayList<String> xVals = new ArrayList<String>();
 
    for (int i = 0; i < xData.length; i++)
      xVals.add(xData[i]);
 
    // create pie data set
    PieDataSet dataSet = new PieDataSet(yVals1, "");
    dataSet.setSliceSpace(3);
    dataSet.setSelectionShift(5);
 
    // add many colors
    ArrayList<Integer> colors = new ArrayList<Integer>();
 
    for (int c : ColorTemplate.VORDIPLOM_COLORS)
      colors.add(c);
 
    for (int c : ColorTemplate.JOYFUL_COLORS)
      colors.add(c);
 
    for (int c : ColorTemplate.COLORFUL_COLORS)
      colors.add(c);
 
    for (int c : ColorTemplate.LIBERTY_COLORS)
      colors.add(c);
 
    for (int c : ColorTemplate.PASTEL_COLORS)
      colors.add(c);
 
    colors.add(ColorTemplate.getHoloBlue());
    dataSet.setColors(colors);
    dataSet.setDrawValues(false);
 
    // instantiate pie data object now
    
    PieData data = new PieData(xVals, dataSet);
    data.setValueFormatter(new PercentFormatter());
    data.setValueTextSize(11f);
    data.setValueTextColor(Color.GRAY);
    mChart.setDrawSliceText(false);
    mChart.getLegend().setEnabled(false);
    mChart.setData(data);
    mChart.setDrawSliceText(false);
 
 
    // undo all highlights
    mChart.highlightValues(null);
 
    // update pie chart
    mChart.invalidate();
  }
 
  private void addData1(int yData1[]) {
	    ArrayList<Entry> yVals1 = new ArrayList<Entry>();
	 
	    for (int i = 0; i < yData1.length; i++)
	      yVals1.add(new Entry(yData1[i], i));
	 
	    ArrayList<String> xVals = new ArrayList<String>();
	 
	    for (int i = 0; i < xData1.length; i++)
	      xVals.add(xData1[i]);
	 
	    // create pie data set
	    PieDataSet dataSet = new PieDataSet(yVals1, null);
	    dataSet.setSliceSpace(3);
	    dataSet.setSelectionShift(5);
	 
	    // add many colors
	    ArrayList<Integer> colors = new ArrayList<Integer>();
	 
	    for(int i=0; i<yData.length; i++)
	    {
	    	 for (int c : ColorTemplate.VORDIPLOM_COLORS)
	   	      colors.add(c);	
	    }
	   
	 
	    colors.add(ColorTemplate.getHoloBlue());
	    
	    
	    dataSet.setColors(colors);
	    dataSet.setDrawValues(false);
	  
	 
	    // instantiate pie data object now
	    PieData data = new PieData(xVals, dataSet);
	    data.setValueFormatter(new PercentFormatter());
	    data.setValueTextSize(0);
	    data.setValueTextColor(Color.GRAY);
	    mChart1.setDrawSliceText(false);
	    mChart1.getLegend().setEnabled(false);
	    mChart1.setData(data);
	    mChart1.setDrawSliceText(false);
	    
	    // undo all highlights
	    mChart1.highlightValues(null);
	 
	    // update pie chart
	    mChart1.invalidate();
	  }
	 
}