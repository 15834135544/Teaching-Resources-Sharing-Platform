package com.zd.christopher.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.style.UpdateAppearance;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.zd.christopher.R;
import com.zd.christopher.bean.Quiz;

public class QuizFragment extends Fragment
{
	private RadioGroup choices;
	private TextView question;
	private RadioButton choiceA;
	private RadioButton choiceB;
	private RadioButton choiceC;
	private RadioButton choiceD;
	private List<Quiz> quizList = new ArrayList<Quiz>();
	private int number = 0;
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			choices.setEnabled(true);
			choiceA.setTextColor(Color.BLACK);
			choiceB.setTextColor(Color.BLACK);
			choiceC.setTextColor(Color.BLACK);
			choiceD.setTextColor(Color.BLACK);
			updateQuestion();	
		}
	};


	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.quiz_fragment, null);
		
		Quiz quiz1 = new Quiz("完整的计算机系统应包括______。", "运算器、存储器和控制器", "外部设备和主机", "主机和实用程序", "配套的硬件设备和软件系统", "配套的硬件设备和软件系统");
		Quiz quiz2 = new Quiz("计算机系统中的存储器系统是指______。", "RAM存储器", "ROM存储器", "主存储器", "主存储器和外存储器", "主存储器和外存储器");
		Quiz quiz3 = new Quiz("冯·诺依曼机工作方式的基本特点是______。", "多指令流单数据流", "按地址访问并顺序执行指令", "堆栈操作", "存储器按内部选择地址", "按地址访问并顺序执行指令");
		Quiz quiz4 = new Quiz("下列说法中不正确的是______。", "任何可以由软件实现的操作也可以由硬件来实现", "固件就功能而言类似于软件，而从形态来说又类似于硬件", "在计算机系统的层次结构中，微程序级属于硬件级，其他四级都是软件级", "面向高级语言的机器是完全可以实现的", "面向高级语言的机器是完全可以实现的");
		Quiz quiz5 = new Quiz("在下列数中最小的数为______。", "(101001)2", "(52)8", "(101001)BCD", "(233)16", "(101001)BCD");
		quizList.add(quiz1);
		quizList.add(quiz2);
		quizList.add(quiz3);
		quizList.add(quiz4);
		quizList.add(quiz5);
		
		choices = (RadioGroup) view.findViewById(R.id.choices);
		question = (TextView) view.findViewById(R.id.question);
		choiceA = (RadioButton) view.findViewById(R.id.choice_a);
		choiceB = (RadioButton) view.findViewById(R.id.choice_b);
		choiceC = (RadioButton) view.findViewById(R.id.choice_c);
		choiceD = (RadioButton) view.findViewById(R.id.choice_d);		
		
		question.setText(quizList.get(number).getQuestion());
		choiceA.setText(quizList.get(number).getChoiceA());
		choiceB.setText(quizList.get(number).getChoiceB());
		choiceC.setText(quizList.get(number).getChoiceC());
		choiceD.setText(quizList.get(number).getChoiceD());
		
		choices.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				switch (checkedId)
				{
					case R.id.choice_a:
						choices.clearCheck();
						choices.setEnabled(false);
						if(quizList.get(number).getAnswer().equals(choiceA.getText()))
							choiceA.setTextColor(Color.GREEN);
						else
						{
							choiceA.setTextColor(Color.RED);
							if(quizList.get(number).getAnswer().equals(choiceB.getText()))
								choiceB.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceC.getText()))
								choiceC.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceD.getText()))
								choiceD.setTextColor(Color.GREEN);
						}
						handler.sendEmptyMessageDelayed(0, 2000);
						break;
					case R.id.choice_b:
						choices.clearCheck();
						choices.setEnabled(false);
						if(quizList.get(number).getAnswer().equals(choiceB.getText()))
							choiceB.setTextColor(Color.GREEN);
						else
						{
							choiceB.setTextColor(Color.RED);
							if(quizList.get(number).getAnswer().equals(choiceA.getText()))
								choiceA.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceC.getText()))
								choiceC.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceD.getText()))
								choiceD.setTextColor(Color.GREEN);
						}
						handler.sendEmptyMessageDelayed(0, 2000);
						break;
					case R.id.choice_c:
						choices.clearCheck();
						choices.setEnabled(false);
						if(quizList.get(number).getAnswer().equals(choiceC.getText()))
						{
							choiceC.setTextColor(Color.GREEN);
						}
						else
						{
							choiceC.setTextColor(Color.RED);
							if(quizList.get(number).getAnswer().equals(choiceA.getText()))
								choiceA.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceB.getText()))
								choiceB.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceD.getText()))
								choiceD.setTextColor(Color.GREEN);
						}
						handler.sendEmptyMessageDelayed(0, 2000);
						break;
					case R.id.choice_d:
						choices.clearCheck();
						choices.setEnabled(false);
						if(quizList.get(number).getAnswer().equals(choiceD.getText()))
						{
							choiceD.setTextColor(Color.GREEN);
						}
						else
						{
							choiceD.setTextColor(Color.RED);
							if(quizList.get(number).getAnswer().equals(choiceA.getText()))
								choiceA.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceB.getText()))
								choiceB.setTextColor(Color.GREEN);
							else if(quizList.get(number).getAnswer().equals(choiceC.getText()))
								choiceC.setTextColor(Color.GREEN);		
						}
						handler.sendEmptyMessageDelayed(0, 2000);
						break;
					default:
						break;
				}
			}
		});
	    return view;
	}
	
	public void updateQuestion()
	{
		number ++;
		if(quizList.size() <= number)
		{
			number = 0;
			choices.setVisibility(View.INVISIBLE);
			question.setText("恭喜你完成了本单元的测试！");
		}
		else
		{
			question.setText(quizList.get(number).getQuestion());
			choiceA.setText(quizList.get(number).getChoiceA());
			choiceB.setText(quizList.get(number).getChoiceB());
			choiceC.setText(quizList.get(number).getChoiceC());
			choiceD.setText(quizList.get(number).getChoiceD());
		}
	}
}
