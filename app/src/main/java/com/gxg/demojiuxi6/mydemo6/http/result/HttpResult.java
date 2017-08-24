package com.gxg.demojiuxi6.mydemo6.http.result;

/**
 * @author yuliuyue
 */
public class HttpResult<T> {

    private String _code;
    private String _msg;
    private T _data;

    public String get_code() {
        return _code;
    }

    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_msg() {
        return _msg;
    }

    public void set_msg(String _msg) {
        this._msg = _msg;
    }

    public T get_data() {
        return _data;
    }

    public void set_data(T _data) {
        this._data = _data;
    }
}
