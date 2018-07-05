package UmerSoftwares;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Hafiz Muhammad Umer
 */
public class MainClass extends javax.swing.JFrame {
    
    JButton[] disp,days;
    ImageIcon[] icnb,icng,icnr,icns,dispi=new ImageIcon[42],disph=new ImageIcon[42],daysi=new ImageIcon[7],daysh=new ImageIcon[7];
    int[] highlighted={-1,-1,-1,-1,-1,-1};
    int dh=-1;
    public MainClass() {
        initComponents();
        //All the display calendar boxes in an array
        JButton[] dispt={bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17,bt18,bt19,bt20,bt21,bt22,bt23,bt24,bt25,bt26,bt27,bt28,bt29,bt30,bt31,bt32,bt33,bt34,bt35,bt36,bt37,bt38,bt39,bt40,bt41,bt42};
        disp=dispt;
        //To make the window appear the centre of the screen
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        // set title and icon of the window
        this.setTitle((char)34+"Date to Calendar"+(char)34+" by Umer Softwares");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        // settings for the ok button
        ImageIcon Ok=new ImageIcon(getClass().getResource("OK.png"));
        Button.setIcon(Ok);
        trans(Button);
        //Report a bug button
        trans(bug);
        ImageIcon bugi=new ImageIcon(getClass().getResource("bug.png"));
        bug.setIcon(bugi);
        bug.setToolTipText("Report a bug");
        // settings for the info button
        ImageIcon info=new ImageIcon(getClass().getResource("info.png"));
        binfo.setIcon(info);
        trans(binfo);
        // settings for the clickable URL
        trans(burl);
        HashMap <TextAttribute,Object> textAttrMap=new HashMap<TextAttribute,Object>();
        textAttrMap.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        burl.setFont(burl.getFont().deriveFont(textAttrMap));
        //Settings for email button
        trans(email);
        email.setFont(email.getFont().deriveFont(textAttrMap));
        //Website button
        trans(web);
        web.setFont(web.getFont().deriveFont(textAttrMap));
        //Umer's Algorithm button
        trans(dtd);
        dtd.setFont(dtd.getFont().deriveFont(textAttrMap));
        //Source code button
        trans(scd);
        scd.setFont(scd.getFont().deriveFont(textAttrMap));
        //Make all the calendar boxes transparent
        for (JButton b:disp)
        {
            trans(b);
        }
        ImageIcon[] icnb=new ImageIcon[31];
        ImageIcon[] icng=new ImageIcon[31];
        ImageIcon[] icnr=new ImageIcon[31];
        ImageIcon[] icns=new ImageIcon[31];
        for (int i=0;i<31;i++)
        {
            icnb[i]=new ImageIcon(getClass().getResource("/UmerSoftwares/black/b"+(i+1)+".png"));
            icng[i]=new ImageIcon(getClass().getResource("/UmerSoftwares/green/g"+(i+1)+".png"));
            icnr[i]=new ImageIcon(getClass().getResource("/UmerSoftwares/red/r"+(i+1)+".png"));
            icns[i]=new ImageIcon(getClass().getResource("/UmerSoftwares/special/s"+(i+1)+".png"));
        }
        this.icnb=icnb;
        this.icng=icng;
        this.icnr=icnr;
        this.icns=icns;
        //Get current date and display its calendar
        DateFormat df=new SimpleDateFormat("d");
        DateFormat mf=new SimpleDateFormat("M");
        DateFormat yf=new SimpleDateFormat("y");
        Date dat=new Date();
        int d=Integer.parseInt(df.format(dat));
        int m=Integer.parseInt(mf.format(dat));
        String y=yf.format(dat);
        set(d,m,y); 
        dtin.transferFocus();
        JButton[] days={d1,d2,d3,d4,d5,d6,d7};
        this.days=days;
        int count=1;
        for (JButton j:days)
        {
            trans(j);
            ImageIcon temp=new ImageIcon(getClass().getResource("/UmerSoftwares/days/d"+count+".png"));
            daysi[count-1]=temp;
            j.setIcon(temp);
            ImageIcon temp2=new ImageIcon(getClass().getResource("/UmerSoftwares/daysh/d"+count+".png"));
            daysh[count-1]=temp2;
            j.setRolloverIcon(temp2);
            count++;
        }
        dtin.setTransferHandler(null);
        mtin.setTransferHandler(null);
        yrin.setTransferHandler(null);        
    }
    private void trans(JButton b)
    {
        //Makes a button transparent
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
    }
    private void set(int d,int m,String s)
    {
        //display the calendar to the user
        int st=date.day(1, m, s);
        if (st==0)
            st=7;
        int[] mds={0,31,0,31,30,31,30,31,31,30,31,30,31};
        if (date.isLeap(s))
            mds[2]=29;
        else
            mds[2]=28;
        for (int i=0;i<42;i++)
        {
            disp[i].setIcon(null);
            dispi[i]=null;
            disph[i]=null;
        }
        int count=0;
        for (int i=0;i<mds[m];i++)
        {
            switch ((count+st-1)%7) 
            {
                case 0:
                case 4:
                    dispi[count+st-1]=icng[count];
                    disp[count+st-1].setIcon(icng[count]);
                    break;
                case 5:
                case 6:
                    dispi[count+st-1]=icnr[count];
                    disp[count+st-1].setIcon(icnr[count]);
                    break;
                default:
                    dispi[count+st-1]=icnb[count];
                    disp[count+st-1].setIcon(icnb[count]);
                    break;
            }
            disph[count+st-1]=icns[count];
            disp[count+st-1].setRolloverIcon(disph[count+st-1]);
            count++;
        }
        String[] mtn={"","January","February","March","April","May","June","July","August","September","October","November","December"};
        dmonth.setText(mtn[m]);
        if (s.length()>20)
        {
            s=s.substring(0,18)+"...";
        }
        dyear.setText(s);
        if (d!=0)
        {
            highlighted[0]=d+st-2;
            disp[d+st-2].setIcon(disph[d+st-2]);
        }
        if (dh!=-1)
        {
            days[dh].setIcon(daysi[dh]);
            dh=-1;
        }
    }
    private void lineH(int in)
    {
        if (dh!=-1)
        {
            days[dh].setIcon(daysi[dh]);
        }
        for (int i:highlighted)
        {
            if (i!=-1)
                disp[i].setIcon(dispi[i]);
        }
        int count=0;
        for (int i=in;i<41+in;i+=7)
        {
            if (disp[i].getIcon()!=null)
            {
                disp[i].setIcon(disph[i]);
            }
            highlighted[count++]=i;
        }
        days[in].setIcon(daysh[in]);
        dh=in;
        dtin.requestFocus();
    }
    private void highlight(int in)
    {
        if (dh!=-1)
        {
            days[dh].setIcon(daysi[dh]);
        }
        for (int i:highlighted)
        {
            if (i!=-1)
                disp[i].setIcon(dispi[i]);
        }
        if (disp[in-1].getIcon()!=null)
        {
            disp[in-1].setIcon(disph[in-1]);
        }
        int[] h={-1,-1,-1,-1,-1,-1};
        highlighted=h;
        highlighted[0]=in-1;
        dtin.requestFocus();
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dtin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mtin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        yrin = new javax.swing.JTextField();
        Button = new javax.swing.JButton();
        pane2 = new javax.swing.JPanel();
        burl = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JButton();
        web = new javax.swing.JButton();
        dtd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        scd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        bug = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bt22 = new javax.swing.JButton();
        bt29 = new javax.swing.JButton();
        bt36 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt15 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt30 = new javax.swing.JButton();
        bt23 = new javax.swing.JButton();
        bt16 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt24 = new javax.swing.JButton();
        bt31 = new javax.swing.JButton();
        bt38 = new javax.swing.JButton();
        bt37 = new javax.swing.JButton();
        bt17 = new javax.swing.JButton();
        bt28 = new javax.swing.JButton();
        bt27 = new javax.swing.JButton();
        bt26 = new javax.swing.JButton();
        bt25 = new javax.swing.JButton();
        bt35 = new javax.swing.JButton();
        bt34 = new javax.swing.JButton();
        bt33 = new javax.swing.JButton();
        bt32 = new javax.swing.JButton();
        bt42 = new javax.swing.JButton();
        bt41 = new javax.swing.JButton();
        bt40 = new javax.swing.JButton();
        bt39 = new javax.swing.JButton();
        bt20 = new javax.swing.JButton();
        bt19 = new javax.swing.JButton();
        bt21 = new javax.swing.JButton();
        bt18 = new javax.swing.JButton();
        bt10 = new javax.swing.JButton();
        bt11 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt12 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt13 = new javax.swing.JButton();
        bt14 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        d1 = new javax.swing.JButton();
        d6 = new javax.swing.JButton();
        d7 = new javax.swing.JButton();
        d5 = new javax.swing.JButton();
        d4 = new javax.swing.JButton();
        d3 = new javax.swing.JButton();
        d2 = new javax.swing.JButton();
        binfo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dmonth = new javax.swing.JLabel();
        dyear = new javax.swing.JLabel();
        loadt = new javax.swing.JLabel();
        loadp = new javax.swing.JPanel();
        loadi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Date:");

        dtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtinActionPerformed(evt);
            }
        });
        dtin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtinKeyTyped(evt);
            }
        });

        jLabel2.setText("Month:");

        mtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtinActionPerformed(evt);
            }
        });
        mtin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mtinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mtinKeyTyped(evt);
            }
        });

        jLabel3.setText("Year:");

        yrin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yrinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yrinKeyTyped(evt);
            }
        });

        Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonMouseClicked(evt);
            }
        });
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });
        Button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ButtonKeyPressed(evt);
            }
        });

        pane2.setBorder(javax.swing.BorderFactory.createTitledBorder("About:"));

        burl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        burl.setForeground(new java.awt.Color(51, 51, 255));
        burl.setText("www.UmerSoftwares.blogspot.com");
        burl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        burl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burlActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Developed by:");

        jLabel5.setText("Hafiz Muhammad Umer");

        jLabel7.setText("Email:");

        jLabel8.setText("Website:");

        jLabel9.setText("This software calculates the calendar for the required date.  The calculations are based");

        jLabel10.setText("on Umer's Algorithm for date to day conversion which you can see here:");

        jLabel11.setText("With its highly efficient and powerfull algorithm, the program can calculate the calendar");

        email.setForeground(new java.awt.Color(0, 0, 255));
        email.setText("UmerSoftwares@gmail.com");
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        web.setForeground(new java.awt.Color(0, 0, 255));
        web.setText("www.UmerSoftwares.blogspot.com");
        web.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webActionPerformed(evt);
            }
        });

        dtd.setForeground(new java.awt.Color(0, 0, 255));
        dtd.setText("UmerSoftwares.blogspot.com/2017/02/umers-algorithm-for-date-to-day.html");
        dtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtdActionPerformed(evt);
            }
        });

        jLabel6.setText("upto more than 10^100000 AD within a second with 100% accuracy.");

        jLabel12.setText("This is an open source application. For source code and more info, visit:");

        scd.setForeground(new java.awt.Color(0, 0, 255));
        scd.setText("UmerSoftwares.blogspot.com/2017/11/date-to-calendar-by-umer-softwares.html");
        scd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scdActionPerformed(evt);
            }
        });

        jLabel13.setText("Also visit my website:");

        bug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bugActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane2Layout = new javax.swing.GroupLayout(pane2);
        pane2.setLayout(pane2Layout);
        pane2Layout.setHorizontalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(burl, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pane2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(pane2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(web))
                            .addGroup(pane2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bug, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pane2Layout.setVerticalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane2Layout.createSequentialGroup()
                        .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(bug, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtd, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scd, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(burl)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bt22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt22ActionPerformed(evt);
            }
        });

        bt29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt29ActionPerformed(evt);
            }
        });

        bt36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt36ActionPerformed(evt);
            }
        });

        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });

        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt15ActionPerformed(evt);
            }
        });

        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        bt30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt30ActionPerformed(evt);
            }
        });

        bt23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt23ActionPerformed(evt);
            }
        });

        bt16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt16ActionPerformed(evt);
            }
        });

        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });

        bt24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt24ActionPerformed(evt);
            }
        });

        bt31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt31ActionPerformed(evt);
            }
        });

        bt38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt38ActionPerformed(evt);
            }
        });

        bt37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt37ActionPerformed(evt);
            }
        });

        bt17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt17ActionPerformed(evt);
            }
        });

        bt28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt28ActionPerformed(evt);
            }
        });

        bt27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt27ActionPerformed(evt);
            }
        });

        bt26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt26ActionPerformed(evt);
            }
        });

        bt25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt25ActionPerformed(evt);
            }
        });

        bt35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt35ActionPerformed(evt);
            }
        });

        bt34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt34ActionPerformed(evt);
            }
        });

        bt33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt33ActionPerformed(evt);
            }
        });

        bt32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt32ActionPerformed(evt);
            }
        });

        bt42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt42ActionPerformed(evt);
            }
        });

        bt41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt41ActionPerformed(evt);
            }
        });

        bt40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt40ActionPerformed(evt);
            }
        });

        bt39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt39ActionPerformed(evt);
            }
        });

        bt20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt20ActionPerformed(evt);
            }
        });

        bt19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt19ActionPerformed(evt);
            }
        });

        bt21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt21ActionPerformed(evt);
            }
        });

        bt18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt18ActionPerformed(evt);
            }
        });

        bt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt10ActionPerformed(evt);
            }
        });

        bt11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt11ActionPerformed(evt);
            }
        });

        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt12ActionPerformed(evt);
            }
        });

        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        bt5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt13ActionPerformed(evt);
            }
        });

        bt14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt14ActionPerformed(evt);
            }
        });

        bt6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });

        d1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d1.setForeground(new java.awt.Color(0, 204, 51));
        d1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        d1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d1ActionPerformed(evt);
            }
        });

        d6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d6.setForeground(new java.awt.Color(255, 102, 102));
        d6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d6ActionPerformed(evt);
            }
        });

        d7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d7.setForeground(new java.awt.Color(255, 51, 51));
        d7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d7ActionPerformed(evt);
            }
        });

        d5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d5.setForeground(new java.awt.Color(0, 204, 51));
        d5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d5ActionPerformed(evt);
            }
        });

        d4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d4ActionPerformed(evt);
            }
        });

        d3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d3ActionPerformed(evt);
            }
        });

        d2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt36, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt37, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt38, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt39, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt40, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt41, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt42, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt29, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt30, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt31, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt32, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt33, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt34, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt35, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt22, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt23, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt24, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt25, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt26, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt27, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt28, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt15, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt16, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt18, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt19, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt21, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(d1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(d5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bt22, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt23, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt25, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt26, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt27, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt28, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bt29, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt30, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt32, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt33, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt34, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt35, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bt36, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt37, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt38, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt39, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt40, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt41, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bt42, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(bt31, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(bt24, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bt17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bt10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        binfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binfoActionPerformed(evt);
            }
        });
        binfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                binfoKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        dmonth.setFont(new java.awt.Font("Brush Script MT", 1, 36)); // NOI18N
        dmonth.setForeground(new java.awt.Color(255, 255, 255));
        dmonth.setText("October");

        dyear.setFont(new java.awt.Font("Brush Script MT", 1, 24)); // NOI18N
        dyear.setText("2017");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dyear, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dmonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dyear)))
                .addContainerGap())
        );

        loadt.setFont(new java.awt.Font("Vladimir Script", 1, 24)); // NOI18N

        javax.swing.GroupLayout loadpLayout = new javax.swing.GroupLayout(loadp);
        loadp.setLayout(loadpLayout);
        loadpLayout.setHorizontalGroup(
            loadpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadpLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loadi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        loadpLayout.setVerticalGroup(
            loadpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(loadp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(loadt)
                                        .addGap(60, 60, 60)))
                                .addComponent(binfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mtin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtin)
                            .addComponent(yrin, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yrin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(binfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loadp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadt)))
                        .addGap(18, 18, 18)
                        .addComponent(pane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtinActionPerformed

    private void ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMouseClicked

    private void burlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_burlActionPerformed
        try
        {
            URI u=new URI("http://www.UmerSoftwares.blogspot.com");
            try
            {
                if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(u);
            }catch (IOException e) {}
        } catch (URISyntaxException ex) {}
        dtin.requestFocus();
    }//GEN-LAST:event_burlActionPerformed

    private void bt22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt22ActionPerformed
    highlight(22);        // TODO add your handling code here:
    }//GEN-LAST:event_bt22ActionPerformed

    private void bt29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt29ActionPerformed
    highlight(29);        // TODO add your handling code here:
    }//GEN-LAST:event_bt29ActionPerformed

    private void bt36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt36ActionPerformed
    highlight(36);        // TODO add your handling code here:
    }//GEN-LAST:event_bt36ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed
    highlight(8);        // TODO add your handling code here:
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        highlight(1);
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt15ActionPerformed
    highlight(15);        // TODO add your handling code here:
    }//GEN-LAST:event_bt15ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
    highlight(2);
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt30ActionPerformed
    highlight(30);        // TODO add your handling code here:
    }//GEN-LAST:event_bt30ActionPerformed

    private void bt23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt23ActionPerformed
    highlight(23);        // TODO add your handling code here:
    }//GEN-LAST:event_bt23ActionPerformed

    private void bt16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt16ActionPerformed
    highlight(16);        // TODO add your handling code here:
    }//GEN-LAST:event_bt16ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed
    highlight(9);        // TODO add your handling code here:
    }//GEN-LAST:event_bt9ActionPerformed

    private void bt24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt24ActionPerformed
    highlight(24);        // TODO add your handling code here:
    }//GEN-LAST:event_bt24ActionPerformed

    private void bt31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt31ActionPerformed
    highlight(31);        // TODO add your handling code here:
    }//GEN-LAST:event_bt31ActionPerformed

    private void bt38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt38ActionPerformed
    highlight(38);        // TODO add your handling code here:
    }//GEN-LAST:event_bt38ActionPerformed

    private void bt37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt37ActionPerformed
    highlight(37);        // TODO add your handling code here:
    }//GEN-LAST:event_bt37ActionPerformed

    private void bt17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt17ActionPerformed
    highlight(17);        // TODO add your handling code here:
    }//GEN-LAST:event_bt17ActionPerformed

    private void bt28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt28ActionPerformed
    highlight(28);        // TODO add your handling code here:
    }//GEN-LAST:event_bt28ActionPerformed

    private void bt27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt27ActionPerformed
    highlight(27);        // TODO add your handling code here:
    }//GEN-LAST:event_bt27ActionPerformed

    private void bt26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt26ActionPerformed
    highlight(26);        // TODO add your handling code here:
    }//GEN-LAST:event_bt26ActionPerformed

    private void bt25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt25ActionPerformed
    highlight(25);        // TODO add your handling code here:
    }//GEN-LAST:event_bt25ActionPerformed

    private void bt35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt35ActionPerformed
    highlight(35);        // TODO add your handling code here:
    }//GEN-LAST:event_bt35ActionPerformed

    private void bt34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt34ActionPerformed
    highlight(34);        // TODO add your handling code here:
    }//GEN-LAST:event_bt34ActionPerformed

    private void bt33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt33ActionPerformed
    highlight(33);        // TODO add your handling code here:
    }//GEN-LAST:event_bt33ActionPerformed

    private void bt32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt32ActionPerformed
    highlight(32);        // TODO add your handling code here:
    }//GEN-LAST:event_bt32ActionPerformed

    private void bt42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt42ActionPerformed
    highlight(42);        // TODO add your handling code here:
    }//GEN-LAST:event_bt42ActionPerformed

    private void bt41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt41ActionPerformed
    highlight(41);        // TODO add your handling code here:
    }//GEN-LAST:event_bt41ActionPerformed

    private void bt40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt40ActionPerformed
    highlight(40);        // TODO add your handling code here:
    }//GEN-LAST:event_bt40ActionPerformed

    private void bt39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt39ActionPerformed
    highlight(39);        // TODO add your handling code here:
    }//GEN-LAST:event_bt39ActionPerformed

    private void bt20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt20ActionPerformed
    highlight(20);        // TODO add your handling code here:
    }//GEN-LAST:event_bt20ActionPerformed

    private void bt19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt19ActionPerformed
    highlight(19);        // TODO add your handling code here:
    }//GEN-LAST:event_bt19ActionPerformed

    private void bt21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt21ActionPerformed
    highlight(21);        // TODO add your handling code here:
    }//GEN-LAST:event_bt21ActionPerformed

    private void bt18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt18ActionPerformed
    highlight(18);        // TODO add your handling code here:
    }//GEN-LAST:event_bt18ActionPerformed

    private void bt10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt10ActionPerformed
    highlight(10);        // TODO add your handling code here:
    }//GEN-LAST:event_bt10ActionPerformed

    private void bt11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt11ActionPerformed
    highlight(11);        // TODO add your handling code here:
    }//GEN-LAST:event_bt11ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
    highlight(4);        // TODO add your handling code here:
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt12ActionPerformed
    highlight(12);        // TODO add your handling code here:
    }//GEN-LAST:event_bt12ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
    highlight(3);        // TODO add your handling code here:
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
    highlight(5);        // TODO add your handling code here:
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt13ActionPerformed
    highlight(13);        // TODO add your handling code here:
    }//GEN-LAST:event_bt13ActionPerformed

    private void bt14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt14ActionPerformed
    highlight(14);        // TODO add your handling code here:
    }//GEN-LAST:event_bt14ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
    highlight(6);        // TODO add your handling code here:
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
    highlight(7);       
    }//GEN-LAST:event_bt7ActionPerformed

    private void d1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d1ActionPerformed
    lineH(0);        
    }//GEN-LAST:event_d1ActionPerformed

    private void d6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d6ActionPerformed
    lineH(5);        // TODO add your handling code here:
    }//GEN-LAST:event_d6ActionPerformed

    private void d7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d7ActionPerformed
    lineH(6);        // TODO add your handling code here:
    }//GEN-LAST:event_d7ActionPerformed

    private void d5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d5ActionPerformed
    lineH(4);        // TODO add your handling code here:
    }//GEN-LAST:event_d5ActionPerformed

    private void d4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d4ActionPerformed
    lineH(3);        // TODO add your handling code here:
    }//GEN-LAST:event_d4ActionPerformed

    private void d3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d3ActionPerformed
    lineH(2);        // TODO add your handling code here:
    }//GEN-LAST:event_d3ActionPerformed

    private void d2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d2ActionPerformed
    lineH(1);        // TODO add your handling code here:
    }//GEN-LAST:event_d2ActionPerformed

    private void dtinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtinKeyTyped
        char c=evt.getKeyChar();
        if ((c<'0' || c>'9')&& c!='\b')
        {
            evt.consume();
        }
        if (evt.getKeyChar()=='\n')
            mtin.requestFocus();
    }//GEN-LAST:event_dtinKeyTyped

    private void mtinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mtinKeyTyped
        char c=evt.getKeyChar();
        if ((c<'0' || c>'9')&& c!='\b')
        {
            evt.consume();
        }
        if (evt.getKeyChar()=='\n')
            yrin.requestFocus();
    }//GEN-LAST:event_mtinKeyTyped

    private void yrinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yrinKeyTyped
        char c=evt.getKeyChar();
        if ((c<'0' || c>'9')&& c!='\b')
        {
            evt.consume();
        }
        if (evt.getKeyChar()=='\n')
        {
            dtin.requestFocus();
            ButtonActionPerformed(null);
        }
    }//GEN-LAST:event_yrinKeyTyped
    private boolean chk(String s)
    {
        return true;
    }
    private void initial()
    {
        dtin.setText("");
        mtin.setText("");
        yrin.setText("");
        loadp.setBackground(null);
        loadi.setIcon(null);
        loadt.setText("");
        dtin.requestFocus();
        Button.setEnabled(true);
        dtin.setEditable(true);
        mtin.setEditable(true);
        yrin.setEditable(true);
    }
    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        Button.setEnabled(false);
        dtin.setEditable(false);
        mtin.setEditable(false);
        yrin.setEditable(false);
        ImageIcon ld=new ImageIcon(getClass().getResource("loading.gif"));
        loadi.setIcon(ld);
        loadp.setBackground(Color.black);
        loadt.setText("Processing");
        int d=0,m=0;
        String y="";
        try
        {
            String temp=dtin.getText();
            if (temp.equals(""))
            {
                d=0;
            }
            else
            d=Integer.parseInt(temp);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "You have entered an invalid date.\nPlease enter the date again.", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
            dtin.setText("");
            dtin.requestFocus();
            loadp.setBackground(null);
            loadi.setIcon(null);
            loadt.setText("");
            Button.setEnabled(true);
            dtin.setEditable(true);
            mtin.setEditable(true);
            yrin.setEditable(true);
            return;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "An error occured while reading the date", "Error", JOptionPane.ERROR_MESSAGE);
            initial();
            return;
        }
        try
        {
            String temp=mtin.getText();
            if (temp.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Month text field can not be empty.\nPlease enter the month again", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
                mtin.setText("");
                mtin.requestFocus();
                loadp.setBackground(null);
                loadi.setIcon(null);
                loadt.setText("");
                Button.setEnabled(true);
                dtin.setEditable(true);
                mtin.setEditable(true);
                yrin.setEditable(true);
                return;
            }
            else
            m=Integer.parseInt(temp);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "You have entered an invalid month.\nPlease enter the month again.", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
            mtin.setText("");
            mtin.requestFocus();
            loadp.setBackground(null);
            loadi.setIcon(null);
            loadt.setText("");
            Button.setEnabled(true);
            dtin.setEditable(true);
            mtin.setEditable(true);
            yrin.setEditable(true);
            return;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "An error occured while reading the month.", "Error", JOptionPane.ERROR_MESSAGE);
            initial();
            return;
        }
        try
        {
            String temp=yrin.getText();
            if (temp.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Year text field can not be empty.\nPlease enter the year again.", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
                yrin.setText("");
                yrin.requestFocus();
                loadp.setBackground(null);
                loadi.setIcon(null);
                loadt.setText("");
                Button.setEnabled(true);
                dtin.setEditable(true);
                mtin.setEditable(true);
                yrin.setEditable(true);
                return;
            }
            else
            y=yrin.getText();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "An error occured while reading the year", "Error", JOptionPane.ERROR_MESSAGE);
            initial();
            return;
        }
        if (m<1 || m>12)
            {
                JOptionPane.showMessageDialog(null, "You have entered an invalid month.\nPlease enter the month again.", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
                mtin.setText("");
                mtin.requestFocus();
                loadp.setBackground(null);
                loadi.setIcon(null);
                loadt.setText("");
                Button.setEnabled(true);
                dtin.setEditable(true);
                mtin.setEditable(true);
                yrin.setEditable(true);
                return;
            }
        if (d!=0)
        {
            boolean b=true;
            if (d<0)
                b&=false;
            int[] mds={0,31,0,31,30,31,30,31,31,30,31,30,31};
            mds[2]=date.isLeap(y)? 29 : 28;
            if (d>mds[m])
                b&=false;
            if (!b)
            {
                JOptionPane.showMessageDialog(null, "You have entered an invalid date.\nPlease enter the date again.", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
                dtin.setText("");
                dtin.requestFocus();
                loadp.setBackground(null);
                loadi.setIcon(null);
                loadt.setText("");
                Button.setEnabled(true);
                dtin.setEditable(true);
                mtin.setEditable(true);
                yrin.setEditable(true);
                return;
            }
        }
        set(d,m,y);
        initial();
    }//GEN-LAST:event_ButtonActionPerformed

    private void yrinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yrinKeyPressed
        if (evt.getExtendedKeyCode()==38)
            mtin.requestFocus();
        else if (evt.getExtendedKeyCode()==40)
            Button.requestFocus();
    }//GEN-LAST:event_yrinKeyPressed

    private void mtinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mtinKeyPressed
        if (evt.getExtendedKeyCode()==38)
            dtin.requestFocus();
        else if (evt.getExtendedKeyCode()==40)
            yrin.requestFocus();
    }//GEN-LAST:event_mtinKeyPressed

    private void dtinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtinKeyPressed
        if (evt.getExtendedKeyCode()==40)
            mtin.requestFocus();
    }//GEN-LAST:event_dtinKeyPressed

    private void ButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ButtonKeyPressed
        if (evt.getExtendedKeyCode()==38)
            yrin.requestFocus();
        else if (evt.getExtendedKeyCode()==39)
            binfo.requestFocus();
    }//GEN-LAST:event_ButtonKeyPressed

    private void binfoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_binfoKeyPressed
        if (evt.getExtendedKeyCode()==38)
            yrin.requestFocus();
        else if (evt.getExtendedKeyCode()==37)
            Button.requestFocus();
    }//GEN-LAST:event_binfoKeyPressed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
    try
        {
            URI u=new URI("mailto:UmerSoftwares@gmail.com?subject=Mail%20from%20Date%20To%20Calendar%20application%20user");
            try
            {
                if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(u);
            }catch (IOException e) {}
        } catch (URISyntaxException ex) {}
    dtin.requestFocus();
    }//GEN-LAST:event_emailActionPerformed

    private void webActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webActionPerformed
        try
        {
            URI u=new URI("http://www.UmerSoftwares.blogspot.com");
            try
            {
                if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(u);
            }catch (IOException e) {}
        } catch (URISyntaxException ex) {}
        dtin.requestFocus();
    }//GEN-LAST:event_webActionPerformed

    private void dtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtdActionPerformed
        try
        {
            URI u=new URI("http://umersoftwares.blogspot.com/2017/02/umers-algorithm-for-date-to-day.html");
            try
            {
                if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(u);
            }catch (IOException e) {}
        } catch (URISyntaxException ex) {}
        dtin.requestFocus();
    }//GEN-LAST:event_dtdActionPerformed

    private void scdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scdActionPerformed
        try
        {
            URI u=new URI("http://umersoftwares.blogspot.com/2017/11/date-to-calendar-by-umer-softwares.html");
            try
            {
                if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(u);
            }catch (IOException e) {}
        } catch (URISyntaxException ex) {}
        dtin.requestFocus();
    }//GEN-LAST:event_scdActionPerformed

    private void binfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binfoActionPerformed
    JOptionPane.showMessageDialog(null, "This is my first GUI application in Java Swing.\nI hope I was able to create a good user experience.\nSend your feedback to me at UmerSoftwares@gmail.com\nThanks", "Message", JOptionPane.INFORMATION_MESSAGE);
    dtin.requestFocus();
    }//GEN-LAST:event_binfoActionPerformed

    private void bugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bugActionPerformed
    try
        {
            URI u=new URI("mailto:UmerSoftwares@gmail.com?subject=Date%20to%20Calendar%20bug%20report");
            try
            {
                if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(u);
            }catch (IOException e) {}
        } catch (URISyntaxException ex) {}
    dtin.requestFocus();
    }//GEN-LAST:event_bugActionPerformed

    private void mtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mtinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button;
    private javax.swing.JButton binfo;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt10;
    private javax.swing.JButton bt11;
    private javax.swing.JButton bt12;
    private javax.swing.JButton bt13;
    private javax.swing.JButton bt14;
    private javax.swing.JButton bt15;
    private javax.swing.JButton bt16;
    private javax.swing.JButton bt17;
    private javax.swing.JButton bt18;
    private javax.swing.JButton bt19;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt20;
    private javax.swing.JButton bt21;
    private javax.swing.JButton bt22;
    private javax.swing.JButton bt23;
    private javax.swing.JButton bt24;
    private javax.swing.JButton bt25;
    private javax.swing.JButton bt26;
    private javax.swing.JButton bt27;
    private javax.swing.JButton bt28;
    private javax.swing.JButton bt29;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt30;
    private javax.swing.JButton bt31;
    private javax.swing.JButton bt32;
    private javax.swing.JButton bt33;
    private javax.swing.JButton bt34;
    private javax.swing.JButton bt35;
    private javax.swing.JButton bt36;
    private javax.swing.JButton bt37;
    private javax.swing.JButton bt38;
    private javax.swing.JButton bt39;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt40;
    private javax.swing.JButton bt41;
    private javax.swing.JButton bt42;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton bug;
    private javax.swing.JButton burl;
    private javax.swing.JButton d1;
    private javax.swing.JButton d2;
    private javax.swing.JButton d3;
    private javax.swing.JButton d4;
    private javax.swing.JButton d5;
    private javax.swing.JButton d6;
    private javax.swing.JButton d7;
    private javax.swing.JLabel dmonth;
    private javax.swing.JButton dtd;
    private javax.swing.JTextField dtin;
    private javax.swing.JLabel dyear;
    private javax.swing.JButton email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel loadi;
    private javax.swing.JPanel loadp;
    private javax.swing.JLabel loadt;
    private javax.swing.JTextField mtin;
    private javax.swing.JPanel pane2;
    private javax.swing.JButton scd;
    private javax.swing.JButton web;
    private javax.swing.JTextField yrin;
    // End of variables declaration//GEN-END:variables
}
