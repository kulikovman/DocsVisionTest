package ru.kulikovman.docsvisiontest;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import ru.kulikovman.docsvisiontest.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initFields();

        binding.setModel(this);
    }

    private void initFields() {
        binding.login.addTextChangedListener(loginPasswordWatcher);
        binding.password.addTextChangedListener(loginPasswordWatcher);

        binding.serverAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.databaseListLayout.setVisibility(TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE);
            }
        });
    }

    private TextWatcher loginPasswordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkLoginPassword();
        }
    };

    private void checkLoginPassword() {
        boolean isEmpty = TextUtils.isEmpty(binding.login.getText()) || TextUtils.isEmpty(binding.password.getText());
        binding.loginButton.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
    }

    public void databaseSelect() {
        // Запустить получение списа баз данных

        // Показать индикатор загрузки

        // Скрыть индикатор загрузки

        // Показать диалог со списком баз данных

        // Сохранить имя выбранной базу в поле

        viewModel.getListOfDatabases();

        binding.databaseList.setText("Выбранная база данных");

        binding.loginLayout.setVisibility(View.VISIBLE);
        binding.passwordLayout.setVisibility(View.VISIBLE);
    }

    public void clickLoginButton() {
        // Отправляем запрос на сервер для аутентификации пользователя
        // ...

        // В зависимости от результата показать соответствующее сообщение
        // ...
    }


}
