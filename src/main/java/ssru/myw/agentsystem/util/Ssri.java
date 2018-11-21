package ssru.myw.agentsystem.util;

/**
 * @author: mayiwen
 * @date: 2018/11/16
 */
public class Ssri {
    public static void main(String[] args) {
        String s = "var self = this;\n" +
                "var paramsMessage = {\n" +
                "    \"userPassword\":self.loginUser.oldPassword,\n" +
                "    \"id\": self.loginUser.id\n" +
                "};\n" +
                "axios({\n" +
                "    method: \"GET\",\n" +
                "    url: \"/user/\",\n" +
                "    params: paramsMessage\n" +
                "})\n" +
                "    .then(function (response) {\n" +
                "        data = JSON.parse(response.data);\n" +
                "        if (data == \"success\") {\n" +
                "            self.isok.message1 = true;\n" +
                "            self.message.message1 = \"您的密码输入正确。\"\n" +
                "        } else {\n" +
                "            self.message.message1 = \"您的密码输入错误!!!\"\n" +
                "        }\n" +
                "    })\n" +
                "    .catch(function (error) {\n" +
                "        console.log(error);\n" +
                "    });";
        String[] arrs = s.split("\n");



        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < arrs.length; i++) {
            if (i == (arrs.length - 1)) {
                sb = sb.append(arrs[i]);
            } else {
                sb = sb.append(arrs[i] + "`r`n");
            }
        }


        System.out.println(sb.toString());
    }
}
