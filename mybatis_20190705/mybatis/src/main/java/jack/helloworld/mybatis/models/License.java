package jack.helloworld.mybatis.models;

public class License {

    private String licenseId;
    private Organization organizationId;
    private String licenseType;
    private String productName;
    private Integer licenseMax;
    private Integer licenseAllocated;
    private String comment;



    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getLicenseMax() {
        return licenseMax;
    }

    public void setLicenseMax(Integer licenseMax) {
        this.licenseMax = licenseMax;
    }

    public Integer getLicenseAllocated() {
        return licenseAllocated;
    }

    public void setLicenseAllocated(Integer licenseAllocated) {
        this.licenseAllocated = licenseAllocated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseId='" + licenseId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", licenseType='" + licenseType + '\'' +
                ", productName='" + productName + '\'' +
                ", licenseMax=" + licenseMax +
                ", licenseAllocated=" + licenseAllocated +
                ", comment='" + comment + '\'' +
                '}';
    }
}
