package com.ityuan.dubbo.design.chain;

/**
 * 抽象出面试官职能对象
 *
 * @Author ityuan
 * @Date 2019-06-28 15:14
 */
public abstract class AbstractInterviewer {
    /**
     * 下一轮面试官角色
     */
    protected AbstractInterviewer nextInterviewer;

    /**
     * 设置下一轮面试官
     *
     * @param nextInterviewer
     * @return
     */
    public AbstractInterviewer setNextInterviewer(AbstractInterviewer nextInterviewer) {
        this.nextInterviewer = nextInterviewer;
        return this.nextInterviewer;
    }

    /**
     * 处理
     *
     * @param interviewee
     */
    public void process(Interviewee interviewee) {
        //本轮面试
        audition(interviewee);
        if (!interviewee.isHasNext()){
            System.out.println("面试不合格");
            return;
        }
        if (nextInterviewer == null) {
            System.out.println("面试结束");
            return;
        }
        //下一轮面试
        nextInterviewer.process(interviewee);
    }

    /**
     * 面试
     *
     * @param interviewee
     */
    protected abstract void audition(Interviewee interviewee);
}
