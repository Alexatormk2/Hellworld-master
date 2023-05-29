package net.Alexator.hellworld.entity;

public enum ActionType {
    // @formatter:off
    SIT,
    WAIT,
    FOLLOW,
    MOVE,
    PATROL,
    UNKNOWN;
    // @formatter:on

    public static ActionType get(String actionType) {
        if (actionType == null || actionType.isEmpty()) {
            return ActionType.UNKNOWN;
        }
        try {
            return ActionType.valueOf(actionType);
        } catch (IllegalArgumentException e) {
            return ActionType.UNKNOWN;
        }
    }
}
