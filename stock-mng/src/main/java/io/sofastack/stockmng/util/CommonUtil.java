package io.sofastack.stockmng.util;

import io.sofastack.stockmng.model.ProductInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/6/12 9:32 PM
 * @since:
 **/
public class CommonUtil {

    private static class ValueComparator implements Comparator<Map.Entry<ProductInfo,Integer>> {
        @Override
        public int compare(Map.Entry<ProductInfo,Integer> m,Map.Entry<ProductInfo,Integer> n)
        {
            return n.getValue()-m.getValue();
        }
    }

    public static List<ProductInfo> sorted(Map<ProductInfo,Integer> map){
        List<ProductInfo> result = new ArrayList<>();
        List<Map.Entry<ProductInfo,Integer>> list=new ArrayList<>();

        list.addAll(map.entrySet());
        ValueComparator vc=new ValueComparator();
        Collections.sort(list,vc);

        for(Iterator<Map.Entry<ProductInfo,Integer>> it=list.iterator();it.hasNext();) {
            result.add(it.next().getKey());
        }
        return result;
    }



}
