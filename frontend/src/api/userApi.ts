import type { ApiResponse, PageResponse, PageRequest } from '@/types/api';
import type { User, CreateUserRequest } from '@/types/user';

import axiosInstance from '@/utils/axios';

export const userApi = {
	getUser: async (id: number): Promise<User> => {
		const response = await axiosInstance.get<ApiResponse<User>>(`/v1/users/${id}`);
		return response.data.data;
	},

	searchUsers: async (keyword?: string, pageRequest?: PageRequest): Promise<PageResponse<User>> => {
		const params = {
			keyword,
			page: pageRequest?.page || 0,
			size: pageRequest?.size || 20,
			sortBy: pageRequest?.sortBy || 'createdAt',
			direction: pageRequest?.direction || 'DESC',
		};
		const response = await axiosInstance.get<ApiResponse<PageResponse<User>>>('/v1/users', {
			params,
		});
		return response.data.data;
	},

	createUser: async (request: CreateUserRequest): Promise<User> => {
		const response = await axiosInstance.post<ApiResponse<User>>('/v1/users', request);
		return response.data.data;
	},
};
