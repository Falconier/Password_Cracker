package main;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Jacob Emory Bullin - Falconier
 * @version v1.2
 * @since Sept. 9, 2019
 */
public class PasswordCracker extends JFrame
{

	private static final long serialVersionUID = -4618455014683461955L;
	private static final boolean DEBUG = true;
	private JTextField txtSetOne;
	private JTextField txtSetTwo;
	private JTextField txtSetThree;
	private JTextField txtSetFour;
	private JLabel lblSetFive;
	private JTextField txtSetFive;
	private JLabel lblOutput;
	private JLabel lblTheWord;
	private String[] keyVals =
	{ "about", "after", "again", "below", "could", "every", "first", "found", "great", "house", "large", "learn",
			"never", "other", "place", "plant", "point", "right", "small", "sound", "spell", "still", "study", "their",
			"there", "these", "thing", "think", "three", "water", "where", "which", "world", "would", "write" };

	private String[] debugVals =
	{ "zokxct", "ivfudh", "afwegj", "bazchs", "aifpxe" };
	// {"uikzdw","trmkol","ghbuze","fcxuld","mdkliz"};

	private char[] setOne;
	private char[] setTwo;
	private char[] setThree;
	private char[] setFour;
	private char[] setFive;

	public PasswordCracker()
	{
		setTitle("Password Cracker - Falconier");
		setSize(600, 450);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JLabel lblSetOne = new JLabel("Set One");
		springLayout.putConstraint(SpringLayout.NORTH, lblSetOne, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSetOne, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblSetOne);

		txtSetOne = new JTextField((DEBUG) ? debugVals[0].toString() : "");
		springLayout.putConstraint(SpringLayout.NORTH, txtSetOne, 6, SpringLayout.SOUTH, lblSetOne);
		springLayout.putConstraint(SpringLayout.WEST, txtSetOne, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtSetOne, 170, SpringLayout.WEST, getContentPane());
		getContentPane().add(txtSetOne);
		txtSetOne.setColumns(10);

		JLabel lblSetTwo = new JLabel("Set Two");
		springLayout.putConstraint(SpringLayout.NORTH, lblSetTwo, 6, SpringLayout.SOUTH, txtSetOne);
		springLayout.putConstraint(SpringLayout.WEST, lblSetTwo, 0, SpringLayout.WEST, lblSetOne);
		getContentPane().add(lblSetTwo);

		txtSetTwo = new JTextField((DEBUG) ? debugVals[1].toString() : "");
		springLayout.putConstraint(SpringLayout.NORTH, txtSetTwo, 6, SpringLayout.SOUTH, lblSetTwo);
		springLayout.putConstraint(SpringLayout.WEST, txtSetTwo, 0, SpringLayout.WEST, lblSetOne);
		springLayout.putConstraint(SpringLayout.EAST, txtSetTwo, 0, SpringLayout.EAST, txtSetOne);
		getContentPane().add(txtSetTwo);
		txtSetTwo.setColumns(10);

		JLabel lblSetThree = new JLabel("Set Three");
		springLayout.putConstraint(SpringLayout.NORTH, lblSetThree, 6, SpringLayout.SOUTH, txtSetTwo);
		springLayout.putConstraint(SpringLayout.WEST, lblSetThree, 0, SpringLayout.WEST, lblSetOne);
		getContentPane().add(lblSetThree);

		txtSetThree = new JTextField((DEBUG) ? debugVals[2].toString() : "");
		springLayout.putConstraint(SpringLayout.NORTH, txtSetThree, 6, SpringLayout.SOUTH, lblSetThree);
		springLayout.putConstraint(SpringLayout.WEST, txtSetThree, 0, SpringLayout.WEST, lblSetOne);
		springLayout.putConstraint(SpringLayout.EAST, txtSetThree, 0, SpringLayout.EAST, txtSetOne);
		getContentPane().add(txtSetThree);
		txtSetThree.setColumns(10);

		JLabel lblSetFour = new JLabel("Set Four");
		springLayout.putConstraint(SpringLayout.NORTH, lblSetFour, 6, SpringLayout.SOUTH, txtSetThree);
		springLayout.putConstraint(SpringLayout.WEST, lblSetFour, 0, SpringLayout.WEST, lblSetOne);
		getContentPane().add(lblSetFour);

		txtSetFour = new JTextField((DEBUG) ? debugVals[3].toString() : "");
		springLayout.putConstraint(SpringLayout.NORTH, txtSetFour, 6, SpringLayout.SOUTH, lblSetFour);
		springLayout.putConstraint(SpringLayout.WEST, txtSetFour, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtSetFour, 0, SpringLayout.EAST, txtSetOne);
		getContentPane().add(txtSetFour);
		txtSetFour.setColumns(10);

		lblSetFive = new JLabel("Set Five");
		springLayout.putConstraint(SpringLayout.NORTH, lblSetFive, 6, SpringLayout.SOUTH, txtSetFour);
		springLayout.putConstraint(SpringLayout.WEST, lblSetFive, 0, SpringLayout.WEST, lblSetOne);
		getContentPane().add(lblSetFive);

		txtSetFive = new JTextField((DEBUG) ? debugVals[4].toString() : "");
		springLayout.putConstraint(SpringLayout.NORTH, txtSetFive, 6, SpringLayout.SOUTH, lblSetFive);
		springLayout.putConstraint(SpringLayout.WEST, txtSetFive, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtSetFive, 170, SpringLayout.WEST, getContentPane());
		getContentPane().add(txtSetFive);
		txtSetFive.setColumns(10);

		JButton btnCrack = new JButton("Start Crack");
		btnCrack.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, btnCrack, 26, SpringLayout.SOUTH, txtSetFive);
		springLayout.putConstraint(SpringLayout.WEST, btnCrack, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCrack, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCrack, 272, SpringLayout.WEST, getContentPane());
		btnCrack.setFont(new Font("Tahoma", Font.PLAIN, 35));
		getContentPane().add(btnCrack);

		lblOutput = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, lblOutput, -46, SpringLayout.NORTH, btnCrack);
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 80));
		springLayout.putConstraint(SpringLayout.WEST, lblOutput, 15, SpringLayout.EAST, txtSetOne);
		springLayout.putConstraint(SpringLayout.EAST, lblOutput, -32, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblOutput);

		lblTheWord = new JLabel("The Word");
		springLayout.putConstraint(SpringLayout.NORTH, lblOutput, 6, SpringLayout.SOUTH, lblTheWord);
		springLayout.putConstraint(SpringLayout.NORTH, lblTheWord, 0, SpringLayout.NORTH, lblSetOne);
		springLayout.putConstraint(SpringLayout.WEST, lblTheWord, 0, SpringLayout.WEST, lblOutput);
		getContentPane().add(lblTheWord);

		JButton btnClearVals = new JButton("Clear Values");
		btnClearVals.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
				{
					txtSetOne.setText("");
					txtSetTwo.setText("");
					txtSetThree.setText("");
					txtSetFour.setText("");
					txtSetFive.setText("");
					lblOutput.setText("");
				}
		});
		btnClearVals.setBackground(Color.RED);
		springLayout.putConstraint(SpringLayout.NORTH, btnClearVals, 0, SpringLayout.NORTH, btnCrack);
		springLayout.putConstraint(SpringLayout.WEST, btnClearVals, -272, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnClearVals, 0, SpringLayout.SOUTH, btnCrack);
		springLayout.putConstraint(SpringLayout.EAST, btnClearVals, -10, SpringLayout.EAST, getContentPane());
		btnClearVals.setFont(new Font("Tahoma", Font.PLAIN, 35));
		getContentPane().add(btnClearVals);

		btnCrack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
				{
					setOne = txtSetOne.getText().toCharArray();
					setTwo = txtSetTwo.getText().toCharArray();
					setThree = txtSetThree.getText().toCharArray();
					setFour = txtSetFour.getText().toCharArray();
					setFive = txtSetFive.getText().toCharArray();

//					String testVal = "";

					ArrayList<Integer> viableSet = new ArrayList<Integer>();
					ArrayList<Integer> finalSet = new ArrayList<Integer>();

					for (int i = 0; i < setOne.length; i++)
					{
						System.out.println(
								setOne[i] + " " + setTwo[i] + " " + setThree[i] + " " + setFour[i] + " " + setFive[i]);
					}

					for (int i = 0; i < setOne.length; i++)
					{
						for (int j = 0; j < keyVals.length; j++)
						{
							if (keyVals[j].substring(0, 1).charAt(0) == setOne[i])
							{
								viableSet.add(j);
							}
						}
					}
					for (int i = 0; i < setFive.length; i++)
					{
						for (int j = 0; j < viableSet.size(); j++)
						{
							String testVal = keyVals[viableSet.get(j)];
							if (testVal.substring(testVal.length() - 1, testVal.length()).charAt(0) == setFive[i])
							{
								finalSet.add(viableSet.get(j));
							}
						}
					}
					if (finalSet.size() == 1)
					{
						lblOutput.setText(keyVals[finalSet.get(0)].toUpperCase());
					} else
					{
						viableSet.clear();
						for (int i = 0; i < setTwo.length; i++)
						{
							for (int j = 0; j < finalSet.size(); j++)
							{
								String testVal = keyVals[finalSet.get(j)];
								if (testVal.substring(1, 2).charAt(0) == setTwo[i])
								{
									viableSet.add(finalSet.get(j));
								}
							}
						}

						if (viableSet.size() == 1)
						{
							lblOutput.setText(keyVals[viableSet.get(0)].toUpperCase());
						} else
						{
							finalSet.clear();
							for (int i = 0; i < setThree.length; i++)
							{
								for (int j = 0; j < viableSet.size(); j++)
								{
									String testVal = keyVals[viableSet.get(j)];
									if (testVal.substring(2, 3).charAt(0) == setThree[i])
									{
										finalSet.add(viableSet.get(j));
									}
								}
							}
							if (finalSet.size() == 1)
							{
								lblOutput.setText(keyVals[finalSet.get(0)].toUpperCase());
							} else
							{
//								lblOutput.setText("!ERROR!");

								viableSet.clear();
								for (int i = 0; i < setFour.length; i++)
								{
									for (int j = 0; j < finalSet.size(); j++)
									{
										String testVal = keyVals[finalSet.get(j)];
										if (testVal.substring(3, 4).charAt(0) == setFour[i])
										{
											viableSet.add(finalSet.get(j));
										}
									}
								}

								if (viableSet.size() == 1)
								{
									lblOutput.setText(keyVals[viableSet.get(0)].toUpperCase());
								}
								else
								{
									lblOutput.setText("!ERROR!");
								}
							}
						}
					}
				}
		});

		setVisible(true);
	}

	public static void main(String[] args)
		{
			PasswordCracker window = new PasswordCracker();
			window.setDefaultCloseOperation(EXIT_ON_CLOSE);

		}
}
