package jack.helloworld.activiti.common.enums;

public enum BpmProcessEnum {

    PROJECT_APPROVAL_PROCESS("project_approval_process");

    private String processId;

    BpmProcessEnum(String processId) {
        this.processId = processId;
    }

    public String getProcessId() {
        return processId;
    }
}
