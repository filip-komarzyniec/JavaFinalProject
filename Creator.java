package po.crawler.web.project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Creator implements Observer {
    private JTextField name1;
    private JTextField weapon1;
    private JTextField boots1;
    private JButton upname1;
    private JButton downname1;
    private JButton upweapon1;
    private JButton downweapon1;
    private JButton upboots1;
    private JButton downboots1;
    private JTextField type1;
    private JButton warriorbutton1;
    private JButton tankbutton1;
    private JTextField health1;
    private JTextField armor1;
    private JTextField force1;
    private JTextField witchcraft1;
    private JTextField name2;
    private JTextField type2;
    private JTextField weapon2;
    private JTextField boots2;
    private JTextField health2;
    private JTextField force2;
    private JTextField armor2;
    private JTextField witchcraft2;
    private JButton upname2;
    private JButton downname2;
    private JButton warriorbutton2;
    private JButton tankbutton2;
    private JButton upweapon2;
    private JButton downweapon2;
    private JButton upboots2;
    private JButton downboots2;
    private JButton magbutton1;
    private JButton magbutton2;
    private JPanel panel;
    private JButton FIGHTButton;
    private JLabel label1;
    private JLabel img1;
    private JLabel img2;
    private JTextField result1;
    private JTextField result2;
    private JButton reset;
    private JLabel resultimg1;
    private JLabel resultimg2;
    private JProgressBar progressBar1;
    private Character character1;
    private Character character2;

    private ImageIcon img_vs = new ImageIcon(this.getClass().getResource("images/vs.jpg"));
    private ImageIcon img_battle = new ImageIcon(this.getClass().getResource("images/battle.png"));
    private ImageIcon img_winner = new ImageIcon(this.getClass().getResource("images/cup.png"));
    private ImageIcon img_loser = new ImageIcon(this.getClass().getResource("images/skull.png"));
    private ImageIcon img_work = new ImageIcon(this.getClass().getResource("images/work.png"));




    public Creator(Character character1, Character character2){


        Image image1 = img_vs.getImage(); // transform it
        image1 = image1.getScaledInstance(110, 110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img_vs = new ImageIcon(image1);  // transform it back


        Image image2 = img_battle.getImage(); // transform it
        image2 = image2.getScaledInstance(110, 110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img_battle = new ImageIcon(image2);  // transform it back

        Image image3 = img_winner.getImage(); // transform it
        image3 = image3.getScaledInstance(110, 110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img_winner = new ImageIcon(image3);  // transform it back

        Image image4 = img_loser.getImage(); // transform it
        image4 = image4.getScaledInstance(110, 110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img_loser = new ImageIcon(image4);  // transform it back

        Image image5 = img_work.getImage(); // transform it
        image5 = image5.getScaledInstance(110, 110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img_work = new ImageIcon(image5);  // transform it back

        this.character1=character1;
        this.character2=character2;

        label1.setIcon(img_vs);
        resultimg1.setIcon(img_work);
        resultimg2.setIcon(img_work);



        name1.setText("CHOOSE CHARACTER");
        name2.setText("CHOOSE CHARACTER");
        type1.setText("CHOOSE TYPE");
        type2.setText("CHOOSE TYPE");
        weapon1.setText("CHOOSE WEAPON");
        weapon2.setText("CHOOSE WEAPON");
        boots1.setText("CHOOSE FOOTGEAR");
        boots2.setText("CHOOSE FOOTGEAR");


        // BOHATER NR 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        health1.setText(Integer.toString(character1.getHealth()));
        armor1.setText(Integer.toString(character1.getArmor()));
        witchcraft1.setText(Integer.toString(character1.getWitchcraft()));
        force1.setText(Integer.toString(character1.getForce()));

        upname1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.changeup();
                name1.setText(character1.getName());
            }
        });
        downname1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    character1.changedown();
                    name1.setText(character1.getName());
                }
        });
        warriorbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.warrior();
                type1.setText(character1.getType());
                refreshfirst();
            }
        });

        magbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.mag();
                type1.setText(character1.getType());
                refreshfirst();
            }
        });

        tankbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.tank();
                type1.setText(character1.getType());
                refreshfirst();
            }
        });

        upweapon1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.item.changeup();
                weapon1.setText(character1.item.getName());
                refreshfirst();
            }
        });

        downweapon1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.item.changedown();
                weapon1.setText(character1.item.getName());
                refreshfirst();
            }
        });

        upboots1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.boot.changeup();
                boots1.setText(character1.boot.getName());
                refreshfirst();
            }
        });

        downboots1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character1.boot.changedown();
                boots1.setText(character1.boot.getName());
                refreshfirst();
            }
        });


        //BOHATER NR 2  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        health2.setText(Integer.toString(character2.getHealth()));
        armor2.setText(Integer.toString(character2.getArmor()));
        witchcraft2.setText(Integer.toString(character2.getWitchcraft()));
        force2.setText(Integer.toString(character2.getForce()));

        upname2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.changeup();
                name2.setText(character2.getName());
                }
        });
        downname2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.changedown();
                name2.setText(character2.getName());
            }
        });
        warriorbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.warrior();
                type2.setText(character2.getType());
                refreshsecond();
            }
        });

        magbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.mag();
                type2.setText(character2.getType());
                refreshsecond();
            }
        });

        tankbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.tank();
                type2.setText(character2.getType());
                health2.setText(Integer.toString(character2.getHealth()));
                 refreshsecond();
            }
        });

        upweapon2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.item.changeup();
                weapon2.setText(character2.item.getName());
                refreshsecond();
            }
        });

        downweapon2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.item.changedown();
                weapon2.setText(character2.item.getName());
                refreshsecond();
            }
        });

        upboots2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.boot.changeup();
                boots2.setText(character2.boot.getName());
                refreshsecond();
            }
        });

        downboots2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character2.boot.changedown();
                boots2.setText(character2.boot.getName());
                refreshsecond();
            }
        });

        FIGHTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(character1.getName()!="" && character2.getName()!=""){
                    int sum1 = character1.getHealth() + character1.getForce() + character1.getArmor() + character1.getWitchcraft();
                    int sum2 = character2.getHealth() + character2.getForce() + character2.getArmor() + character2.getWitchcraft();

                    label1.setIcon(img_battle);

                    if(sum1>sum2){
                        result1.setText("WINNER");
                        resultimg1.setIcon(img_winner);
                        result2.setText("LOSER");
                        resultimg2.setIcon(img_loser);
                    }
                    else if(sum1==sum2){
                        result1.setText("REMIS");
                        resultimg1.setIcon(img_winner);
                        result2.setText("REMIS");
                        resultimg2.setIcon(img_winner);
                    }
                    else {
                        result1.setText("LOSER");
                        resultimg1.setIcon(img_loser);
                        result2.setText("WINNER");
                        resultimg2.setIcon(img_winner);
                    }
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result1.setText("");
                result2.setText("");
                resultimg1.setIcon(img_work);
                resultimg2.setIcon(img_work);

                character1.reset();
                character2.reset();

                character1.setName("");
                character2.setName("");

                name1.setText("CHOOSE CHARACTER");
                name2.setText("CHOOSE CHARACTER");
                type1.setText("CHOOSE TYPE");
                type2.setText("CHOOSE TYPE");
                weapon1.setText("CHOOSE WEAPON");
                weapon2.setText("CHOOSE WEAPON");
                boots1.setText("CHOOSE FOOTGEAR");
                boots2.setText("CHOOSE FOOTGEAR");

                health1.setText("0");
                armor1.setText("0");
                witchcraft1.setText("0");
                force1.setText("0");

                health2.setText("0");
                armor2.setText("0");
                witchcraft2.setText("0");
                force2.setText("0");

                label1.setIcon(img_vs);
                img1.setIcon(new ImageIcon(this.getClass().getResource("images/trophy.png")));
                img1.setText("Postać");
                img2.setIcon(new ImageIcon(this.getClass().getResource("images/trophy.png")));
                img2.setText("Postać");
            }
        });
        character1.subscribe(this::update);
        character2.subscribe(this::update);
    }
// Observer update method
    public void update() {
        if (character1.getPointer()== -1){;}
        else{
            img1.setIcon(new ImageIcon(this.getClass().getResource((String.format("champions_png/image%d.png",character1.getPointer())))));
            img1.setText(GetLOL.characters.get(character1.getPointer()));}
        if (character2.getPointer() == -1) {;}
        else {
            img2.setIcon(new ImageIcon(this.getClass().getResource(String.format("champions_png/image%d.png", character2.getPointer()))));
            img2.setText(GetLOL.characters.get(character2.getPointer()));}
    }
    public static void main(String[] args) {
        GetLOL.download();  // pobieram wszystko

        Character warrior_one = new Character();
        Character warrior_two = new Character();

        JFrame frame = new JFrame("battle");
        frame.setContentPane(new Creator(warrior_one,warrior_two).panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void refreshfirst() throws NullPointerException{
        health1.setText(Integer.toString(character1.getHealth()));
        armor1.setText(Integer.toString(character1.getArmor()));
        witchcraft1.setText(Integer.toString(character1.getWitchcraft()));
        force1.setText(Integer.toString(character1.getForce()));

    }
    public void refreshsecond() throws NullPointerException{
        health2.setText(Integer.toString(character2.getHealth()));
        armor2.setText(Integer.toString(character2.getArmor()));
        witchcraft2.setText(Integer.toString(character2.getWitchcraft()));
        force2.setText(Integer.toString(character2.getForce()));
    }

// personalizowane komponenty
    private void createUIComponents() {
            img1 = new JLabel("postać", new ImageIcon(this.getClass().getResource("images/trophy.png")), JLabel.CENTER);
            img1.setVerticalTextPosition(JLabel.TOP);
            img1.setHorizontalTextPosition(JLabel.CENTER);
            img1.setIconTextGap(4);

            img2 = new JLabel("postac", new ImageIcon(this.getClass().getResource("images/trophy.png")), JLabel.CENTER);
            img2.setVerticalTextPosition(JLabel.TOP);
            img2.setHorizontalTextPosition(JLabel.CENTER);
            img2.setIconTextGap(4);
    }
}