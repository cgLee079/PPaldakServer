package com.cglee079.ppaldak.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.cglee079.ppaldak.log.Log;

public class Test {

	public static void main(String[] args) throws IOException {
		// serverURL 가져옴
		String reqeustURL = "http://localhost:9999/PPaldakServer/login";
		
		String parameter = "";
		String line;

		String id = "cksrn2979";
		String password = "1";

		// Parameter
		parameter += "&id=" + id;
		parameter += "&pwd=" + password;

		// 최종 접속 URL
		Log.i("URL " + reqeustURL);

		// String->URL
		URL url = new URL(reqeustURL);

		// Http Connect
		HttpURLConnection connect = (HttpURLConnection) url.openConnection(); // URL을
																				// 연결한
																				// 객체
																				// 생성.
		Log.i("Connect  " + connect);

		connect.setConnectTimeout(3000);

		connect.setRequestMethod("POST"); // get방식 통신
		connect.setDoOutput(true); // 쓰기모드 지정
		connect.setDoInput(true); // 읽기모드 지정
		connect.setUseCaches(false); // 캐싱데이터를 받을지 안받을지
		connect.setDefaultUseCaches(false); // 캐싱데이터 디폴트 값 설정

		OutputStream outputStream = connect.getOutputStream();
		outputStream.write(parameter.getBytes());
		outputStream.flush();
		outputStream.close();

		InputStream is = connect.getInputStream(); // input스트림 개방

		StringBuilder mBuilder = new StringBuilder(); // 문자열을 담기 위한 객체
		BufferedReader mReader = new BufferedReader(new InputStreamReader(is, "UTF-8")); // 문자열
																							// 셋
																							// 세팅

		// 요청이 정상적으로 전달되엇으면 HTTP_OK(200) 리턴
		// URL이 발견되지 않으면 HTTP_NOT_FOUND(404) 리턴
		// 인증에 실패하면 HTTP_UNAUTHORIZED(401) 리턴
		int responseCode = connect.getResponseCode();
		Log.i("HTTP_STATE :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) {

			// 버퍼의 웹문서 소스를 줄 단위로 읽어 저장
			while ((line = mReader.readLine()) != null) {
				mBuilder.append(line + "\n");
			}
		}

		mReader.close();
		String page = mBuilder.toString();
		Log.i("HTTP_OK page: " + page);

	}

}
