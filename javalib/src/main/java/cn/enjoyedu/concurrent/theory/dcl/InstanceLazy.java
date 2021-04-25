package cn.enjoyedu.concurrent.theory.dcl;

/**
 * 在域上运用延迟初始化占位类模式
 *
 * @author xzy
 */
public class InstanceLazy {
    /**
     * 成员变量很耗资源
     */
    private Integer value;

    public InstanceLazy(Integer value) {
        super();
        this.value = value;
    }

    private static class InstanceHolder {
        public static Integer val = new Integer(100);
    }

    public Integer getValue() {
        return value;
    }

    public Integer getVal() {
        return InstanceHolder.val;
    }

}
