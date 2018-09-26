package com.lgp.creationalpattern.builder;

import com.lgp.creationalpattern.builder.domain.Product;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/14 10:50
 * @DESCRIPTION 建造模式就是 多个建造方法建造一个产品
 * <p>
 * 那么可分为
 * Builder          建造者 抽象类，建造方法和返回产品的方法
 * ConcreteBuilder  具体建造者
 * Director         导演，具体建造者的调用
 * Product          产品
 * <p>
 * 返回产品的方法若是固定的可写个默认方法，按书中所说默认方法的情况更为普遍
 * 但是，实际使用，我的写法不仅有默认方法，还把具体建造者 和 具体建造者的调用 合并
 * 这里那里好我就不说了，因为使用的情况不多。
 * <p>
 * ps.看过mybatis的源码发现默认方法写不写，其实很有可能是一个代码习惯
 * 个人感觉写默认方法是个好习惯？求大佬解决疑问。
 * <p>
 * 变种1
 * 具体建造者的调用 导演里的成员可以直接是具体调用者
 * 这也是书中所说的大多数情况
 * ps2.可以看出java于模式的作者也觉得建造者模式的实际使用其实一直都是他的阉割版
 * 而单例，多例，工厂这些模式都是扩展板，哪个比较重要，实用。很明显了啊。建造者模式可以说了解即可了。
 * <p>
 * 变种2
 * 具体建造者 和 具体建造者的调用 合并
 * 在返回产品的方法调用建造方法即可
 * <p>
 * 变种3
 * 产品也搞成抽象的，就能返回多种产品
 * <p>
 * 变种4
 * 具体建造者 和 导演 和 建造者合并
 * ps3.看到这里的时候，我真的想说，建造者模式存在的意义？
 * 建造者有多个产品构造方法，生成不同的产品，，，，简单点的例子就是不同参数的构造方法...
 * <p>
 * 重点：
 * 作者认为
 * 1.需要生成的产品有复杂的内部结构。产品成员有多个对象，对象里面的成员也有多个对象
 * 2.生成的产品的属性相互依赖，具体就是connect必须有ip，port什么的赋值
 * <p>
 * 最后，思维发散的同学也应该发现了，建造者模式的变种不止以上四种
 * 还有一种常见的
 * 连接mq，数据库等的
 * Connect conn;
 * conn.setPort();//之类 本质上就是一种建造者模式的建造方法
 * Channel chan=con.getChannel();//则是生成产品类...
 * 也就是说返回数据的方法的数据结构，包含多个数据都能说是建造者模式的变种....
 * 完美契合作者的认为啊
 * <p>
 * 那么，看起来作者并没有黑建造者模式，而是把建造者模式提炼的很精简！我喜欢！
 **/
abstract public class Builder {
    abstract public void buildPart1();

    abstract public void buildPart2();

    abstract public Product retrieveResult();

}
