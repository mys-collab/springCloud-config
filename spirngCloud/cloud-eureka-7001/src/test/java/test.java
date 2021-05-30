import java.util.*;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer num = i;
            al.add(num);

        }
        System.out.println("数组中的元素");

        Iterator<Integer> iterator = al.iterator();
        //迭代器
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("===="+next);
        }
        //增强for
        for (Integer integer : al) {

            System.out.println(integer);
        }

        for (int i = 0; i < al.size(); i++) {
            Integer temp=(al.get(i));
            System.out.println(temp);
        }
        System.out.println("---------------");


        al.clear();

        System.out.println("数组被清空");
        System.out.println(al.size());
        if(al.isEmpty()) {
            System.out.println("数据为空");
        }
        else {
            System.out.println("数据不为空");
        }

        Map<Object, Object> map = new HashMap<>();
        map.put("1",20);
        for (Map.Entry<Object, Object> mpa : map.entrySet()) {
            Object key = mpa.getKey();
            Object value = mpa.getValue();
            map.remove(key);

        }
    }
}
