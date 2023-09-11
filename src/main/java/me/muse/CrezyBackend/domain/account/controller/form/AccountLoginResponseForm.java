package me.muse.CrezyBackend.domain.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@RequiredArgsConstructor
public class AccountLoginResponseForm {
    final private String nickname;
    final private String roleType;
    final private String userToken;
}
