package com.nativespeakerai.push_notifications.model.repository;

import com.nativespeakerai.push_notifications.model.entity.FcmToken;
import org.springframework.data.repository.CrudRepository;

public interface FcmTokenRepository extends CrudRepository<FcmToken, String> {
}
