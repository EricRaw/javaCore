package com.eric.myThreadLocal;

import java.util.concurrent.ConcurrentHashMap;
 /**
 * @author EricRaww
 * @create 2021-04-30
  * Thread 是Thread的 局部变量
 */
public class MyThreadLocal {
    private ConcurrentHashMap<Thread,Object> valueMap=new ConcurrentHashMap<>();
    public void set(Object newValue){
        valueMap.put(Thread.currentThread(),newValue);
    }
    public Object get(){
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);
        if(o==null && !valueMap.containsKey(currentThread)){
            o=initialValue();
            valueMap.put(currentThread,o);
        }
        return o;
    }
    public void remove(){
        valueMap.remove(Thread.currentThread());
    }
    public Object initialValue(){
        return null;
    }

}
