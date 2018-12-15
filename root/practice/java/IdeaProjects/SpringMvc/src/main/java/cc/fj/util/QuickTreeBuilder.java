package cc.fj.util;

/**
 * Created by asus on 2015/11/26.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuickTreeBuilder {
    public static void main(String args[]){

        List<Node> result=new ArrayList<Node>();
        for(int i=1;i<5;i++){
            result.add(new Node(i+"",i-1+"","name"+i));
        }

        Map<String,Node> nodeMap=new HashMap<String, Node>();
        for(Node node:result){
            nodeMap.put(node.getId(),node);
        }

        List<Node> list=new ArrayList<Node>();
        for(Map.Entry<String,Node> entry:nodeMap.entrySet()){
            Node node=entry.getValue();
            if(node.getParentId().equals("0")){
                list.add(node);
            }else{
                String parentId=node.getParentId();
                Node parentNode=nodeMap.get(parentId);
                parentNode.addChild(node);
            }
        }

        System.out.println(list);
        System.out.println("============================================================");

        List<Map<String,Object>> listOfMap=new ArrayList<Map<String, Object>>();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id","1");
        map.put("pid",null);
        map.put("name","computer");
        listOfMap.add(map);

        map=new HashMap<String, Object>();
        map.put("id","11");
        map.put("pid","1");
        map.put("name","monitor");
        listOfMap.add(map);

        map=new HashMap<String, Object>();
        map.put("id","12");
        map.put("pid","1");
        map.put("name","keyboard");
        listOfMap.add(map);

        map=new HashMap<String, Object>();
        map.put("id","2");
        map.put("pid",null);
        map.put("name","house");
        listOfMap.add(map);

        map=new HashMap<String, Object>();
        map.put("id","21");
        map.put("pid","2");
        map.put("name","window");
        listOfMap.add(map);

        map=new HashMap<String, Object>();
        map.put("id","22");
        map.put("pid","2");
        map.put("name","door");
        listOfMap.add(map);

        List<Map<String,Object>> resultTree=new ArrayList<Map<String, Object>>();
        for(Map<String,Object> m:listOfMap){
            List<Map<String,Object>> subTree=createTree(listOfMap,m);
            m.put("subTree",subTree);
            resultTree.add(m);
        }
        System.out.println(resultTree);
    }

    static List<Map<String,Object>> createTree(List<Map<String,Object>> list,Map<String,Object> map){
        List<Map<String,Object>> subTreeOfMap=new ArrayList<Map<String, Object>>();
        for(Map<String,Object> m:list){
            if(m.get("pid")==null){
                continue;
            }
            if(m.get("pid").equals(map.get("id"))){
                List<Map<String,Object>> subTree=createTree(list,m);
                m.put("subTree",subTree);
                subTreeOfMap.add(m);
            }
        }
        return subTreeOfMap;
    }


    static class Node{
        private String id;
        private String parentId;
        private String name;
        private List<Node> subNodes=new ArrayList<Node>();

        public void addChild(Node node){
            subNodes.add(node);
        }

        public Node(String id, String parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Node> getSubNodes() {
            return subNodes;
        }

        public void setSubNodes(List<Node> subNodes) {
            this.subNodes = subNodes;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id='" + id + '\'' +
                    ", parentId='" + parentId + '\'' +
                    ", name='" + name + '\'' +
                    ", subNodes=" + subNodes +
                    '}';
        }
    }

}

