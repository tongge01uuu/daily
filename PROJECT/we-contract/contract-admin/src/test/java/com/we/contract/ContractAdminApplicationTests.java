package com.we.contract;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.contract.dao.ContractTemplateMapper;
import com.we.contract.service.ContractTemplateService;
import com.we.contract.service.system.UserService;
import com.we.contract.vo.ContractTemplateVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-service.xml" })
public class ContractAdminApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private ContractTemplateMapper contractTemplateMapper;
	@Autowired
	private ContractTemplateService contractTemplateService;
	@Value("${file.root.path}")
	private String fileRootPath;

	@Test
	public void test() throws Exception{
		PageHelper.startPage(2,2);
		List list= contractTemplateService.list(null);
		PageInfo pageInfo=new PageInfo(list);
		System.out.println(JSON.toJSONString(pageInfo));
	}

	@Test
	public void download() {
		System.out.println(fileRootPath);
		byte[] buffer = new byte[1024];
		String path=fileRootPath+"sql-old/alter-contract-table.sql";
		File file=new File(path);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		StringBuffer stringBuffer=new StringBuffer();

		try {
//			boolean optResult=file.renameTo(new File(path.replace(".","111.")));
			System.out.println(file.getAbsolutePath()+"\n"+file.getCanonicalPath());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			int i = bis.read(buffer);
			while (i != -1) {
				System.out.println(new String(buffer,0,i));
				stringBuffer.append(new String(buffer,0,i));
//				os.write(buffer, 0, i);
				i = bis.read(buffer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println(stringBuffer.toString());
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


}
