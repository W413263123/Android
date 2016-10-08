package com.example.ClassText.Class9a2;

/**
 * Created by wenkui on 16/9/13.
 */
public class AlarmClass {
    /** 延迟的时间 */
    private int delay;
    /** 是否发出声音 */
    private boolean flag;
    /** 构造方法 */
    public AlarmClass(int delay, boolean flag) {
        this.delay = delay;
        this.flag = flag;
    }

    /**
     开始进行闹钟
    public void start() {
        class Printer implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("k:m:s");
                String result = format.format(new Date());
                System.out.println("当前时间是:" + result);
                if (flag) {
                    Toolkit.getDefaultToolfit().beep();
                }
            }
        }
        new Timer(delay, new Printer()).start;
    }
     */
}
