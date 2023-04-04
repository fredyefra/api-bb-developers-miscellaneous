package br.com.bb.developers.service.impl;

import org.springframework.stereotype.Service;

import br.com.bb.developers.model.OAuth2;
import br.com.bb.developers.service.OAuth2Wrapper;


@Service
public class OAuth2Service implements OAuth2Wrapper {

	@Override
	public OAuth2 oauthObject(String response_type, String client_id, String redirect_uri, String scope, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2 oauthObject2(OAuth2 oAuth2) {
		// TODO Auto-generated method stub
		return null;
	}

}
