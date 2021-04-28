package Hard;

import java.util.HashMap;
import java.util.Map;

public class Solution65 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] sarr = s.toCharArray();
        Map<StateType, Map<CharType, StateType>> map = new HashMap<>();
        Map<CharType, StateType> initialMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_SIGN, StateType.STATE_SIGN);
            put(CharType.CHAR_DIGIT, StateType.STATE_DIGIT);
            put(CharType.CHAR_POINT, StateType.STATE_POINT_WITHOUT_DIGIT);
        }};
        map.put(StateType.STATE_INITIAL, initialMap);
        Map<CharType, StateType> signMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_DIGIT, StateType.STATE_DIGIT);
            put(CharType.CHAR_POINT, StateType.STATE_POINT_WITHOUT_DIGIT);
        }};
        map.put(StateType.STATE_SIGN, signMap);
        Map<CharType, StateType> digitMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_EXP, StateType.STATE_EXP);
            put(CharType.CHAR_DIGIT, StateType.STATE_DIGIT);
            put(CharType.CHAR_POINT, StateType.STATE_POINT);
        }};
        map.put(StateType.STATE_DIGIT, digitMap);
        Map<CharType, StateType> pointMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_EXP, StateType.STATE_EXP);
            put(CharType.CHAR_DIGIT, StateType.STATE_FRACTION);
        }};
        map.put(StateType.STATE_POINT, pointMap);
        Map<CharType, StateType> pointWithoutDigitMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_DIGIT, StateType.STATE_FRACTION);
        }};
        map.put(StateType.STATE_POINT_WITHOUT_DIGIT, pointWithoutDigitMap);
        Map<CharType, StateType> fractionMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_DIGIT, StateType.STATE_FRACTION);
            put(CharType.CHAR_EXP, StateType.STATE_EXP);
        }};
        map.put(StateType.STATE_FRACTION, fractionMap);
        Map<CharType, StateType> expMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_SIGN, StateType.STATE_EXP_SIGN);
            put(CharType.CHAR_DIGIT, StateType.STATE_EXP_DIGIT);
        }};
        map.put(StateType.STATE_EXP, expMap);
        Map<CharType, StateType> expSignMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_DIGIT, StateType.STATE_EXP_DIGIT);
        }};
        map.put(StateType.STATE_EXP_SIGN, expSignMap);
        Map<CharType, StateType> expDigitMap = new HashMap<CharType, StateType>(){{
            put(CharType.CHAR_DIGIT, StateType.STATE_EXP_DIGIT);
        }};
        map.put(StateType.STATE_EXP_DIGIT, expDigitMap);

        StateType stype = StateType.STATE_INITIAL;
        for (char c : sarr) {
            CharType ct = toCharType(c);
            if (map.get(stype) == null || !map.get(stype).containsKey(ct)) {
                return false;
            }
            stype = map.get(stype).get(ct);
        }
        return stype == StateType.STATE_DIGIT || stype == StateType.STATE_POINT || stype == StateType.STATE_FRACTION || stype == StateType.STATE_EXP_DIGIT;
    }


    public CharType toCharType(char c) {
        if (Character.isDigit(c)) {
            return CharType.CHAR_DIGIT;
        } else if (c == '.') {
            return CharType.CHAR_POINT;
        } else if (c == '+' || c == '-') {
            return CharType.CHAR_SIGN;
        } else if (c == 'e' || c == 'E') {
            return CharType.CHAR_EXP;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum StateType {
        STATE_INITIAL,
        STATE_SIGN,
        STATE_DIGIT,
        STATE_POINT,
        STATE_POINT_WITHOUT_DIGIT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_DIGIT
    }
    enum CharType {
        CHAR_SIGN,
        CHAR_DIGIT,
        CHAR_POINT,
        CHAR_EXP,
        CHAR_ILLEGAL
    }
}
