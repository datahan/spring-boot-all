package com.datahan.springbootall.zookeeper.lock;

import com.datahan.springbootall.zookeeper.lock.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-17 15:35
 */
@Slf4j
public class Tester {

    @Test
    public void stream() {
        IntStream.range(0, 10000).forEach(i -> System.out.println(i + "oo"));
    }

    @Test
    public void testTreeSet() {
        ArrayList<Map<String, Object>> lists = new ArrayList<>();

        HashMap<String, Object> hashMap1 = new HashMap<>();
        hashMap1.put("id", 10L);
        hashMap1.put("name","2.1");
        hashMap1.put("parentId",0L);
        lists.add(hashMap1);

        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("id", 8L);
        hashMap2.put("name","abc");
        hashMap2.put("parentId",0L);
        lists.add(hashMap2);

        HashMap<String, Object> hashMap3 = new HashMap<>();
        hashMap3.put("id", 12L);
        hashMap3.put("name","ggg");
        hashMap3.put("parentId",0L);
        lists.add(hashMap3);

        HashMap<String, Object> hashMap4 = new HashMap<>();
        hashMap4.put("id", 13L);
        hashMap4.put("name","uu");
        hashMap4.put("parentId",10L);
        lists.add(hashMap4);

        // 构建ID 为KEY 实体为 value的Map
        Map<Long, Map<String, Object>> idMap = new HashMap<>();
        for (Map<String, Object> map : lists) {
            idMap.put((Long) map.get("id"), map);
        }
        // 用来记录 根目录（parentId为0） 的实体ID
        Set<Long> rootIds = new TreeSet<>();
        // 构建树， 思路： 遍历 找到父节点，并放到父节点的children下即可
        for (Map<String, Object> map : lists) {
            Long parentId = (Long) map.get("parentId");
            if (parentId.equals(0L)) {
                rootIds.add((Long) map.get("id"));
            }
            Map<String, Object> tmp = idMap.get(parentId);
            /*if (MapUtils.getInteger(map, "isDirectory").equals(SystemConstants.NO)) {
                map.put("downlodUrl", EmpApplyConstant.DOWN_LOAD_PATH + MapUtils.getString(map, "fileCode"));
            }*/
            if (tmp != null) {
                List<Map<String, Object>> list = (List<Map<String, Object>>) tmp.get("children");
                if (CollectionUtils.isEmpty(list)) {
                    list = new ArrayList<>();
                }
                list.add(map);
                tmp.put("children", list);
            }
        }
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("id", 0);
        returnMap.put("name", "根目录");
        returnMap.put("children", new ArrayList<>());
        for (Long long1 : rootIds) {
            ((List) returnMap.get("children")).add(idMap.get(long1));
        }
        System.out.println(returnMap);
    }

    @Test
    public void testHashMap() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        String x1 = new String("xx");
        String x2 = new String("xx");
        hashMap.put(x1, "first");
        hashMap.put(x2, "second");
        System.out.println(hashMap);

        IdentityHashMap<Object, Object> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(x1, "first");
        identityHashMap.put(x2, "second");
        System.out.println(identityHashMap);
    }

    @Test
    public void testTwoDimensionArray() {
        int[][] arr1 = {{1,2,3},{4,5,6,7}};
        System.out.println(arr1.length);
    }

    @Test
    public void testReflection() {
        Class<?> person = Person.class;
        Field[] declaredFields = person.getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            System.out.println(name);
            Class<? extends Field> aClass = field.getClass();
            System.out.println(aClass.getName());
            System.out.println(aClass.getCanonicalName());
            System.out.println(aClass.getSimpleName());
            System.out.println(aClass.getTypeName());
        }
    }
}
