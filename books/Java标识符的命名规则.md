# [Java标识符的命名规则](https://www.cnblogs.com/ouysq/p/4474267.html)



```
Java语言中，为各种变量、方法和类等起的名字称为标识符
Java标识符的命名规则：
应以字母、下划线、美元符开头
后跟字母、下划线、美元符或数字
Java标识符大小写敏感，长度无限制
1.java中能用作标识符的有：26个英文字母（大、小写），数字，下划线，美元符号$。 
但是不能以数字开头。 
2.类名首个字母必须大写，多个单词组成的，每个单词首字母都要大写。 
3.方法名一般首个字母小写（构造方法例外），多个单词组成方法名，后面单词首字母大写。 
4.变量命名规则同方法名命名规则。 
注意：不能使用java中的关键字做标识符。
```

Java保留关键字

Java语言有51个关键字，其中const和goto虽然被保留但未使用。你不能使用保留关键字来命名类、方法或变量。

**保留关键字**

数据类型：

Boolean    int    long    short    byte    float    double    char    class    interface

流程控制：

if     else    do    while    for    switch    case    default    break    continue    return    try    catch    finally

修饰符：      

public    protected    private    final    void     static    strictfp     abstract     transient

synchronized     volatile    native

动作：          

package    import     throw    throws     extends    implements    this    Super    instanceof    new

保留字：      

true     false    null    goto    const