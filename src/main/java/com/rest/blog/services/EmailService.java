package com.rest.blog.services;

import java.util.ArrayList;

public interface EmailService {

	boolean sendSimpleMail(ArrayList<String> newsletter, int postId);
}
