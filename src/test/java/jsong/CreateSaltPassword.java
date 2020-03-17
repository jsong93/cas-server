    package jsong;

    import org.apache.shiro.crypto.hash.ConfigurableHashService;
    import org.apache.shiro.crypto.hash.DefaultHashService;
    import org.apache.shiro.crypto.hash.HashRequest;
    import org.apache.shiro.util.ByteSource;
    import org.junit.Test;

//    @RunWith(SpringRunner.class)
//    @SpringBootTest
    public class CreateSaltPassword  {
        // 静态盐值
        private String staticSalt = "jsonghome";
        // 加密算法
        private String algorithmName = "MD5";
        // 密码
        private String encodedPassword = "jsong";
        // 用户名 动态盐值
        private String dynaSalt = "jsong";
        // 加密迭代次数
        private int numberOfIterations = 2;

        @Test
        public void test() throws Exception {
            ConfigurableHashService hashService = new DefaultHashService();
            hashService.setPrivateSalt(ByteSource.Util.bytes(this.staticSalt));
            hashService.setHashAlgorithmName(this.algorithmName);
            hashService.setHashIterations(this.numberOfIterations);
            HashRequest request = new HashRequest.Builder()
                    .setSalt(dynaSalt)
                    .setSource(encodedPassword)
                    .build();
            String res = hashService.computeHash(request).toHex();
            System.out.println(res);
        }

    }
