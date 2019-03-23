package top.kwrcee.sortcourse.manage.utils;

public interface Constants {
    interface Flag{
        Integer YES= new Integer(1);
        Integer NO= new Integer(0);
    }
    interface ValueSet{
        /**
         * 楼号
         */
        String BUILDING_NAME="building";
    }
    interface AuthorityPermission{
        /**
         * 添加教室权限
         */
        String ROOM_ADD="add-room";
        /**
         * 修改教室权限
         */
        String ROOM_UPDATE="update-room";
        /**
         * 删除教室权限
         */
        String ROOM_DELETE="delete-room";
        /**
         * 查询教室权限
         */
        String ROOM_LIST="list-room";

    }
    interface DefaultLongNumber{
        Long ONE =new Long(1);
    }
}
