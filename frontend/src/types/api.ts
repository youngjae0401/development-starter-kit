export interface ApiResponse<T> {
	success: boolean;
	message: string;
	data: T;
	error?: ErrorInfo;
}

export interface ErrorInfo {
	code: string;
	message: string;
}

export interface PageResponse<T> {
	content: T[];
	pageInfo: PageInfo;
}

export interface PageInfo {
	currentPage: number;
	pageSize: number;
	totalElements: number;
	totalPages: number;
	first: boolean;
	last: boolean;
}

export interface PageRequest {
	page?: number;
	size?: number;
	sortBy?: string;
	direction?: 'ASC' | 'DESC';
}
