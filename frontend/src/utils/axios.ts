import axios, { AxiosError, AxiosResponse, InternalAxiosRequestConfig } from 'axios';

import type { ApiResponse } from '@/types/api';

const axiosInstance = axios.create({
	baseURL: import.meta.env.VITE_API_BASE_URL || '/api',
	timeout: 10000,
	headers: {
		'Content-Type': 'application/json',
	},
});

// Request Interceptor
axiosInstance.interceptors.request.use(
	(config: InternalAxiosRequestConfig) => {
		const token = localStorage.getItem('accessToken');
		if (token && config.headers) {
			config.headers.Authorization = `Bearer ${token}`;
		}
		return config;
	},
	(error: AxiosError) => {
		return Promise.reject(error);
	},
);

// Response Interceptor
axiosInstance.interceptors.response.use(
	(response: AxiosResponse<ApiResponse<unknown>>) => {
		return response;
	},
	(error: AxiosError<ApiResponse<unknown>>) => {
		if (error.response) {
			const { status, data } = error.response;

			switch (status) {
				case 401:
					localStorage.removeItem('accessToken');
					window.location.href = '/login';
					break;
				case 403:
					alert('Access denied');
					break;
				case 500:
					alert('Internal server error');
					break;
				default:
					if (data?.error) {
						alert(data.error.message);
					}
			}
		}
		return Promise.reject(error);
	},
);

export default axiosInstance;
