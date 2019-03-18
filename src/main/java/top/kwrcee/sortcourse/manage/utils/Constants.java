package top.kwrcee.sortcourse.manage.utils;

public interface Constants {
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
}
