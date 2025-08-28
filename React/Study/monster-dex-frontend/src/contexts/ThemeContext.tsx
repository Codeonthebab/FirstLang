import { createContext } from "react";

// 흑, 백 값을 가질 수 있는 테마 컨텍스트 생성
// createContext의 인자는 기본 값
export const ThemeContext = createContext('light');
