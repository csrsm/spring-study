package org.spring.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    Map<String,Object> map = new ConcurrentHashMap<String,Object>();

    public BeanFactory (String xml) {
        parseXml(xml);

    }

    public void parseXml(String xml) {
        /*使用dom4j解析xml配置文件*/
        File file = new File(this.getClass().getResource("/").getPath() + "//" + xml);
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(file);
            Element root = doc.getRootElement();

            for(Iterator<Element> iteratorFirst = root.elementIterator(); iteratorFirst.hasNext();) {
                /**
                 * 实例化对象
                 */
                Element elementFirstChild = iteratorFirst.next();
                Attribute attributeId = elementFirstChild.attribute("id");
                String beanName = attributeId.getValue();

                Attribute attributeClass = elementFirstChild.attribute("class");
                String clazzName = attributeClass.getValue();
                Class clazz = Class.forName(clazzName);
                Object object = clazz.newInstance();
                /**
                 * 维护依赖关系
                 * 对象是否有依赖(判断bean中是否有属性property)
                 * 有则注入
                 */
                for(Iterator<Element> iteratorSecond = elementFirstChild.elementIterator(); iteratorSecond.hasNext();) {
                    /**
                     * <property name="dao" ref="dao"></property>
                     * 得到ref的value，通过value得到对象
                     * 得到name值，根据值获取Field对象
                     * 通过Field set方法set对象
                     */
                    Element elementSecondChild = iteratorSecond.next();
                    if (elementSecondChild.getName().equals("property")) {
                        String refValue = elementSecondChild.attribute("ref").getValue();
                        Object injectObject =  map.get(refValue);
                        String nameValue = elementSecondChild.attribute("name").getValue();
                        Field field = clazz.getDeclaredField(nameValue);
                        field.setAccessible(true);
                        field.set(object, injectObject);
                    }
                }

                map.put(beanName, object);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }

    public Object getBean(String beanName) {
        return map.get(beanName);
    }

}
