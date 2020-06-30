package org.xyz.mapstruct.daomain;


import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class UserVoTest {
    private static List<Cell> list = new ArrayList<>();

    private static String json = "{\n" +
            "    \"total\" : 135,\n" +
            "    \"max_score\" : 1.0,\n" +
            "    \"hits\" : [\n" +
            "      {\n" +
            "        \"_index\" : \"pm_server_kpi_data\",\n" +
            "        \"_type\" : \"pm_index_data\",\n" +
            "        \"_id\" : \"fXJTUHIBrZ9DR1vGY0-A\",\n" +
            "        \"_score\" : 1.0,\n" +
            "        \"_source\" : {\n" +
            "          \"MessageHeader\" : {\n" +
            "            \"METypeID\" : 10000,\n" +
            "            \"MEVer\" : null,\n" +
            "            \"MsgType\" : \"PM\",\n" +
            "            \"ActualID\" : \"BFEBFBFF000506E3\",\n" +
            "            \"MEModel\" : null,\n" +
            "            \"MsgTime\" : 1590485540623\n" +
            "          },\n" +
            "          \"MessageBody\" : {\n" +
            "            \"fanSpeeds\" : [ ],\n" +
            "            \"totalDiskFreeSpace\" : 981022814208,\n" +
            "            \"cpuUsage\" : 0.1191,\n" +
            "            \"cpuUsed\" : 953,\n" +
            "            \"batteryInfoList\" : [\n" +
            "              {\n" +
            "                \"healthState\" : 0.8901,\n" +
            "                \"batterySn\" : \" \",\n" +
            "                \"healthDesc\" : \"UnHealthy\",\n" +
            "                \"batteryName\" : \"System Battery\"\n" +
            "              }\n" +
            "            ],\n" +
            "            \"totalDiskSpace\" : 1126581497856,\n" +
            "            \"openFileDescriptors\" : 108663,\n" +
            "            \"systemUptime\" : 1590454369,\n" +
            "            \"threadCount\" : 3763,\n" +
            "            \"maxFileDescriptors\" : 16711680,\n" +
            "            \"diskUsageRate\" : 0.1292,\n" +
            "            \"fileUsageStatusList\" : [\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.002,\n" +
            "                \"filePartitionFreeSize\" : 248079265792,\n" +
            "                \"filePartitionTotalSize\" : 248583811072,\n" +
            "                \"fileDesc\" : \"本地固定磁盘 (D:)\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.0023,\n" +
            "                \"filePartitionFreeSize\" : 1.0712088576E11,\n" +
            "                \"filePartitionTotalSize\" : 107373129728,\n" +
            "                \"fileDesc\" : \"本地固定磁盘 (E:)\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.0085,\n" +
            "                \"filePartitionFreeSize\" : 212924219392,\n" +
            "                \"filePartitionTotalSize\" : 214747312128,\n" +
            "                \"fileDesc\" : \"本地固定磁盘 (F:)\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.353,\n" +
            "                \"filePartitionFreeSize\" : 138931576832,\n" +
            "                \"filePartitionTotalSize\" : 214747312128,\n" +
            "                \"fileDesc\" : \"本地固定磁盘 (G:)\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.0022,\n" +
            "                \"filePartitionFreeSize\" : 214267162624,\n" +
            "                \"filePartitionTotalSize\" : 214747312128,\n" +
            "                \"fileDesc\" : \"本地固定磁盘 (H:)\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.8497,\n" +
            "                \"filePartitionFreeSize\" : 10799362048,\n" +
            "                \"filePartitionTotalSize\" : 71857721344,\n" +
            "                \"fileDesc\" : \"本地固定磁盘 (C:)\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.1032,\n" +
            "                \"filePartitionFreeSize\" : 4.890034176E10,\n" +
            "                \"filePartitionTotalSize\" : 54524899328,\n" +
            "                \"fileDesc\" : \"本地固定磁盘 (I:)\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"filePartitionUseRate\" : 0.0,\n" +
            "                \"filePartitionFreeSize\" : 0.0,\n" +
            "                \"filePartitionTotalSize\" : 0.0,\n" +
            "                \"fileDesc\" : \"光盘 (L:)\"\n" +
            "              }\n" +
            "            ],\n" +
            "            \"cpuTemperature\" : 0.0,\n" +
            "            \"totalMemory\" : 17073508352,\n" +
            "            \"availableMemory\" : 5270515712,\n" +
            "            \"cpuTotal\" : 8000,\n" +
            "            \"cpuVoltage\" : 0.0,\n" +
            "            \"processNum\" : 225,\n" +
            "            \"memoryUsageRatie\" : 0.6913\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }";

    public static void main(String[] args) {
        File file = new File("");
        file.length();
        // stackThreadLocal.set(new ArrayList<Cell>());
        parse(json);
        System.out.println(list);
    }

    private static void parse(String json) {
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        parseMap(map, new Cell());
    }

    private static void parseList(List list, Cell cell) {
        for (int i = 0; i < list.size(); i++) {
            //   cell.setOrder(i);
            Object o = list.get(i);
            if (o instanceof Map) {
                parseMap((Map) o, cell);
            } else {
                parseList((List) o, cell);
            }
        }
    }

    private static void parseMap(Map map, Cell cell) {
        map.forEach((v1, v2) -> {
            Cell cell1 = new Cell();
            cell1.setParentId(cell.getId());
            cell1.setId(UUID.randomUUID().toString());
            cell1.setName(v1.toString());
            cell1.setOrder(cell.getOrder());
            if (v2 instanceof Map) {
                list.add(cell1);
                parseMap((Map) v2, cell1);
            } else if (v2 instanceof List) {
                list.add(cell1);
                parseList((List) v2, cell1);
            } else {
                cell1.setValue(v2);
                list.add(cell1);
            }
        });
    }


}

class Cell {
    private String id;
    private String parentId;
    private Integer order;
    private String ActualID;
    private Long msgTime;
    private String name;
    private Object value;

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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getActualID() {
        return ActualID;
    }

    public void setActualID(String actualID) {
        ActualID = actualID;
    }

    public Long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Long msgTime) {
        this.msgTime = msgTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}