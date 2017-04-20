package daily.business.util.rrd.util.rest;

public class RESTRequestInfo {

    /**
     * 请求参数
     */
    private String parameters;
    
    /**
     * url
     */
    
    /**
     * 请求路径
     */
    private String path;
    
    /**
     * 证书密码
     */
    private String certPass;
    /**
     * 证书路径
     */
    private String certPath;
    /**
     * 证书文件名
     */
    private String certFileName;
    
    /**
     * 超时时间
     */
    private int timeOut;

    /**
     * 请求的域名
     */
    private String domainName;
    
    /**
     * HTTP 端口号
     */
    private String port = "80";
    
    /**
     * SSL端口号
     */
    private String sslPort = "443";

    /**
     * Used for basicAuth;
     */
    private boolean basicAuth = Boolean.FALSE;
    private String basicAuthUsername;
    private boolean enableSSL = Boolean.TRUE;
    private String basicAuthPass;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
    
    public String getUrl() {
        
        if (this.domainName.toLowerCase().contains("https:")) {
            return this.domainName + ":" + this.sslPort + path;
        } else {
            return this.domainName + ":" + this.port + path;
        }

    }

//    public void setUrl(String url) {
//        this.url = url;
//    }

    public String getCertPass() {
        return certPass;
    }

    public void setCertPass(String certPass) {
        this.certPass = certPass;
    }

    public String getCertFileName() {
        return certFileName;
    }

    public void setCertFileName(String certFileName) {
        this.certFileName = certFileName;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getSslPort() {
        return sslPort;
    }

    public void setSslPort(String sslPort) {
        this.sslPort = sslPort;
    }

    public String getBasicAuthUsername() {
        return basicAuthUsername;
    }

    public void setBasicAuthUsername(String basicAuthUsername) {
        this.basicAuthUsername = basicAuthUsername;
    }

    public String getBasicAuthPass() {
        return basicAuthPass;
    }

    public void setBasicAuthPass(String basicAuthPass) {
        this.basicAuthPass = basicAuthPass;
    }

    public boolean isBasicAuth() {
        return basicAuth;
    }

    public void setBasicAuth(boolean basicAuth) {
        this.basicAuth = basicAuth;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public boolean isEnableSSL() {
        return enableSSL;
    }

    public void setEnableSSL(boolean enableSSL) {
        this.enableSSL = enableSSL;
    }
    
    public static void main(String[] args){
        System.out.println(("https://www.we.com").contains("https:"));
    }

}
